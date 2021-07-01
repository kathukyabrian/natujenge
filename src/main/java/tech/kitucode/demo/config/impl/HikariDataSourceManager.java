package tech.kitucode.demo.config.impl;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import tech.kitucode.demo.config.DatasourceConfig;
import tech.kitucode.demo.config.DatasourceManager;

import javax.sql.DataSource;

public class HikariDataSourceManager implements DatasourceManager {

    private DataSource dataSource;

    @Override
    public DataSource getDataSource(DatasourceConfig datasourceConfig) {

        if(dataSource==null){
            HikariConfig config = new HikariConfig();

            HikariDataSource hikariDataSource;

            // get jdbc url from datasourceconfig
            String jdbcURL = datasourceConfig.getJdbcUrl();

            // set jdbcURL to HikariConfig
            config.setJdbcUrl(jdbcURL);

            config.setUsername(datasourceConfig.getUsername());

            config.setPassword(datasourceConfig.getPassword());

            config.setDriverClassName(datasourceConfig.getDriverClassName());

            config.addDataSourceProperty("cachePrepStmts",datasourceConfig.isCachePrepStmts()?"true":"false");

            config.addDataSourceProperty("useSSL", datasourceConfig.isUseSSL()?"true":"false");

            if(datasourceConfig.getPrepStmtCacheSize()>0){
                config.addDataSourceProperty("prepStmtCacheSize",datasourceConfig.getPrepStmtCacheSize());
            }

            if(datasourceConfig.getPrepStmtCacheSqlLimit()>0){
                config.addDataSourceProperty("prepStmtCacheSqlLimit",datasourceConfig.getPrepStmtCacheSqlLimit());
            }

            if(datasourceConfig.getMinimumIdle()>0){
                config.setMinimumIdle(datasourceConfig.getMinimumIdle());
            }

            if(datasourceConfig.getMaximumPoolSize()>0){
                config.setMaximumPoolSize(datasourceConfig.getMaximumPoolSize());
            }

            hikariDataSource = new HikariDataSource(config);

            dataSource = hikariDataSource;
        }

        return dataSource;
    }
}
