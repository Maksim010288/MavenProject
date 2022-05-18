package romannumbers.db.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnector {
    private DBConfig dbConfig;

    public SQLConnector(DBConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

    public Connection getDbConnection() {
        try {
            Class.forName(dbConfig.getDbDriver());
            System.out.println("Connect...");
            return DriverManager.getConnection(dbConfig.getDbUrl(),
                    dbConfig.getDbUser(),
                    dbConfig.getDbPass());
        } catch (Exception e) {
            System.err.println("Could not connect");
            throw new RuntimeException(e);
        }
    }
}
