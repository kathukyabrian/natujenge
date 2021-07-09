package tech.kitucode.demo.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.kitucode.demo.repository.CustomerRepository;
import tech.kitucode.demo.utilities.BasicUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

public class BalanceProcessor {

    private final Logger logger = LogManager.getLogger(BalanceProcessor.class);


    public void process(String request, CustomerRepository customerRepository, DataSource dataSource, Map<String, String> processorConfig, Socket socket){
        logger.debug("Received a balance check request : {}",request);

        String accountNumber = BasicUtils.getSecondWord(request);

        logger.debug("Balance : {}",customerRepository.getBalance(accountNumber,dataSource));

        BasicUtils.writeToSocket(socket,customerRepository.getBalance(accountNumber,dataSource));

    }
}
