package tech.kitucode.demo;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.kitucode.demo.config.DatasourceConfig;
import tech.kitucode.demo.config.DatasourceManager;
import tech.kitucode.demo.config.impl.HikariDataSourceManager;
import tech.kitucode.demo.core.Processor;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    private static final int port = 12000;

    private static final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT,true).configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES,true);

    public static void main(String[] args ) throws IOException {

        logger.debug("Initialized log4j2");

        logger.debug("Initializing datasource");

        String id = "MAIN";

        String driverClassName = "com.mysql.cj.jdbc.Driver";

        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/javademo";

        String username = "root";

        String password = "kitunda2018";

        boolean cachePrepStmts = true;

        int prepStmtCacheSize = 250;

        int prepStmtCacheSqlLimit = 2048;

        int minimumIdle = 30;

        DatasourceConfig dataSourceConfig = new DatasourceConfig(id, driverClassName, jdbcUrl, username, password,
                cachePrepStmts, prepStmtCacheSize, prepStmtCacheSqlLimit, minimumIdle);

        DatasourceManager dataSourceManager = new HikariDataSourceManager();

        DataSource dataSource = dataSourceManager.getDataSource(dataSourceConfig);

        logger.info("system|finished initializing dataSource");

        // socket

        Processor processor = new Processor();

        final ServerSocket serverSocket = new ServerSocket(port);

        logger.info("Waiting for client connections on port : {}",serverSocket.getLocalPort());



        while (true){
            final Socket socket = serverSocket.accept();

            Thread thread = new Thread(()->{
                try{
                    logger.info("Client connected with port : {}",socket.getPort());

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    String request;

                    while((request=bufferedReader.readLine())!=null){
                        logger.debug("About to send : {} to PreProcessor",request);
                        processor.queue("tech.kitucode.demo.processors.PreProcessor",request);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }

            },"acceptor-thread");

            thread.start();
        }

    }
}
