package romannumbers.db;

import romannumbers.mappers.MapperType;

import java.sql.*;
import java.util.logging.Logger;

public class MappersDAO {
    private Connection connection;
    private Logger logger = Logger.getLogger("");

    public MappersDAO(Connection connection) {
        this.connection = connection;
    }

    private void create() throws Exception {
        String read = "INSERT INTO mappers (mappersNum, mappersNumType, mappersNumValue) values (?,?,?)";

        PreparedStatement statement = connection.prepareStatement(read);
        statement.setInt(1, 10);
        statement.setString(2, "ROM");
        statement.setString(3, "X");
        statement.execute();
    }

    public String dbpath(Integer number, MapperType mapperType) {
        String outRequest = null;
        try {
            String request = String.format("SELECT * FROM mappers WHERE mappersNum = %s and mappersNumType = %s",
                    "?", "?");
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, number);
            preparedStatement.setString(2, ""+ mapperType +"");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                outRequest = resultSet.getString(4);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outRequest;
    }
}
