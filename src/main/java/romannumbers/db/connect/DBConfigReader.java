package romannumbers.db.connect;

import romannumbers.db.MappersDAO;
import romannumbers.mappers.MapperType;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

public class DBConfigReader {
    private String fileName;

    public DBConfigReader(String fileName) {
        this.fileName = fileName;
    }

    public DBConfig readDBConnectionConfig() throws Exception {
        FileInputStream inputStream = new FileInputStream(fileName);
        Properties properties = new Properties();
        properties.load(inputStream);
        String dbUrl = properties.getProperty("dbURL");
        String dbUser = properties.getProperty("dbUser");
        String dbPass = properties.getProperty("dbPass");
        String driver = properties.getProperty("driver");
        return new DBConfig(dbUrl, dbUser, dbPass, driver);
    }
}
