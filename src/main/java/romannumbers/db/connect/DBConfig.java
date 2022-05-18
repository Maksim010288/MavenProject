package romannumbers.db.connect;

public class DBConfig {

    private String dbUrl;
    private String dbUser;
    private String dbPass;
    private String dbDriver;

    public DBConfig(String dbUrl, String dbUser, String dbPass, String dbDriver) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPass = dbPass;
        this.dbDriver = dbDriver;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPass() {
        return dbPass;
    }

    public String getDbDriver() {
        return dbDriver;
    }
}
