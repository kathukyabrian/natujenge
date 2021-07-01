package tech.kitucode.demo.config;

public class DatasourceConfig {

    private String id;

    private String driverClassName;

    private String jdbcUrl;

    private String username;

    private String password;

    private boolean cachePrepStmts;

    private int prepStmtCacheSize;

    private int prepStmtCacheSqlLimit;

    private boolean useSSL;

    private int minimumIdle;

    private int maximumPoolSize;

    private boolean isAutoCommit;

    private int connectTimeout;

    private int idleTimeout;

    private boolean isReadOnly;

    public DatasourceConfig() {

    }

    public DatasourceConfig(String id, String driverClassName, String jdbcUrl, String username, String password, boolean cachePrepStmts, int prepStmtCacheSize, int prepStmtCacheSqlLimit, int minimumIdle) {
        this.id = id;
        this.driverClassName = driverClassName;
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
        this.cachePrepStmts = cachePrepStmts;
        this.prepStmtCacheSize = prepStmtCacheSize;
        this.prepStmtCacheSqlLimit = prepStmtCacheSqlLimit;
        this.minimumIdle = minimumIdle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCachePrepStmts() {
        return cachePrepStmts;
    }

    public void setCachePrepStmts(boolean cachePrepStmts) {
        this.cachePrepStmts = cachePrepStmts;
    }

    public int getPrepStmtCacheSize() {
        return prepStmtCacheSize;
    }

    public void setPrepStmtCacheSize(int prepStmtCacheSize) {
        this.prepStmtCacheSize = prepStmtCacheSize;
    }

    public int getPrepStmtCacheSqlLimit() {
        return prepStmtCacheSqlLimit;
    }

    public void setPrepStmtCacheSqlLimit(int prepStmtCacheSqlLimit) {
        this.prepStmtCacheSqlLimit = prepStmtCacheSqlLimit;
    }

    public boolean isUseSSL() {
        return useSSL;
    }

    public void setUseSSL(boolean useSSL) {
        this.useSSL = useSSL;
    }

    public int getMinimumIdle() {
        return minimumIdle;
    }

    public void setMinimumIdle(int minimumIdle) {
        this.minimumIdle = minimumIdle;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public boolean isAutoCommit() {
        return isAutoCommit;
    }

    public void setAutoCommit(boolean autoCommit) {
        isAutoCommit = autoCommit;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getIdleTimeout() {
        return idleTimeout;
    }

    public void setIdleTimeout(int idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    public boolean isReadOnly() {
        return isReadOnly;
    }

    public void setReadOnly(boolean readOnly) {
        isReadOnly = readOnly;
    }

    @Override
    public String toString() {
        return "DatasourceConfig{" +
                "id='" + id + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                ", jdbcUrl='" + jdbcUrl + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", cachePrepStmts=" + cachePrepStmts +
                ", prepStmtCacheSize=" + prepStmtCacheSize +
                ", prepStmtCacheSqlLimit=" + prepStmtCacheSqlLimit +
                ", useSSL=" + useSSL +
                ", minimumIdle=" + minimumIdle +
                ", maximumPoolSize=" + maximumPoolSize +
                ", isAutoCommit=" + isAutoCommit +
                ", connectTimeout=" + connectTimeout +
                ", idleTimeout=" + idleTimeout +
                ", isReadOnly=" + isReadOnly +
                '}';
    }
}
