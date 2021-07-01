package tech.kitucode.demo.config;

import javax.sql.DataSource;

public interface DatasourceManager {

    public DataSource getDataSource(DatasourceConfig datasourceConfig);

}
