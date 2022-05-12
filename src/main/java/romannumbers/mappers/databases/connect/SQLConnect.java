package romannumbers.mappers.databases.connect;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnect {
    DBConnectionData dbConnectionData;
    DBConnection connection = new DBConnection("src/main/resources/db/dbConnectionData.properties");

    public SQLConnect(DBConnectionData dbConnectionData) {
        this.dbConnectionData = dbConnectionData;
    }

    public Connection getDbConnect() {
        try {
            DBConnectionData dbConnectionData = connection.getDBConnection();
            String connectionString = String.format(dbConnectionData.getDbUrl() + "://%s:%s/%s",
                    dbConnectionData.getDbHost(),
                    dbConnectionData.getDbPort(),
                    dbConnectionData.getDbName()
                    );
            Class.forName(dbConnectionData.dbDriver);
            System.out.println("Connect");
            return DriverManager.getConnection(connectionString,
                    dbConnectionData.dbUser,
                    dbConnectionData.dbPass);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Not Connect");
        }
        return null;
    }
}
