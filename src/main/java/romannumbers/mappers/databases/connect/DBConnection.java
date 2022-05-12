package romannumbers.mappers.databases.connect;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBConnection {
    protected String fileName;

    public DBConnection(String fileName) {
        this.fileName = fileName;
    }

    public DBConnectionData getDBConnection() throws Exception {
        FileInputStream inputStream = new FileInputStream(fileName);
        Properties properties = new Properties();
        properties.load(inputStream);
        String dbUrl = properties.getProperty("dbURL");
        String dbName = properties.getProperty("dbName");
        String dbHost = properties.getProperty("dbHost");
        String dbPort = properties.getProperty("dbPort");
        String dbUser = properties.getProperty("dbUser");
        String dbPass = properties.getProperty("dbPass");
        String driver = properties.getProperty("driver");
        return new DBConnectionData(dbUrl, dbName, dbHost, dbPort, dbUser, dbPass, driver);
    }
}
