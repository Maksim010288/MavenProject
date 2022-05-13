package romannumbers.mappers.databases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLRequests {
    Connection connection;
    RegisterMapperDb mapperDb = new RegisterMapperDb(
            "idmappers",
            "mappersNum",
            "mappersNumType",
            "mappersNumValue");

    public SQLRequests(Connection connection) {
        this.connection = connection;
    }

    public void create() throws Exception {
        String read = "INSERT INTO mappers (" +
                mapperDb.getMappersNum() + ", " +
                mapperDb.getMappersNumType() + ", " +
                mapperDb.getMappersNumValue() + ") values (?,?,?)";

        PreparedStatement statement = connection.prepareStatement(read);
        statement.setInt(1, 10);
        statement.setString(2, "ROM");
        statement.setString(3, "X");
        statement.execute();
    }

    protected List<String> selectTable(List<Integer> dbColumn, String str) throws SQLException {
        List<String> res = new ArrayList<>();
        String read = "SELECT mappersNum, mappersNumType, mappersNumValue FROM mappers";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(read);
        while (resultSet.next()) {
            for (Integer column : dbColumn) {
                if (column.equals(resultSet.getInt(mapperDb.getMappersNum())) &&
                        resultSet.getString(mapperDb.getMappersNumType()).equals(str)) {
                    res.add(resultSet.getString(mapperDb.getMappersNumValue()));
                }
            }
        }
        return res;
    }

    protected List<String> revers(List<Integer> integerList, String type) throws SQLException {
        List<String> out = new ArrayList<>();
        for (int i = selectTable(integerList, type).size() - 1; i >= 0; i--) {
            out.add(selectTable(integerList, type).get(i));
        }
        return out;
    }

    public void outputResult(List<Integer> dbColumn, String type) {
        try {
            List<String> outputRes = revers(dbColumn, type);
            for (String dbList : outputRes) {
                System.out.print(dbList + " ");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
