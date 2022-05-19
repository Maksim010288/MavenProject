package romannumbers.db;

import romannumbers.OutputNumerals;
import romannumbers.db.connect.DBConfig;
import romannumbers.db.connect.DBConfigReader;
import romannumbers.db.connect.SQLConnector;
import romannumbers.mappers.MapperRegistry;
import romannumbers.mappers.MapperType;
import romannumbers.mappers.db.DBMapper;

import javax.xml.validation.Validator;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

    protected List<String> selectTable(List<Integer> dbColumn, String str) throws SQLException {
        List<String> res = new ArrayList<>();
        String read = "SELECT mappersNum, mappersNumType, mappersNumValue FROM mappers WHERE ";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(read);
        while (resultSet.next()) {
            for (Integer column : dbColumn) {
                if (column.equals(resultSet.getInt("mappersNum")) &&
                        resultSet.getString("mappersNumType").equals(str)) {
                    res.add(resultSet.getString("mappersNumValue"));
                }
            }
        }
        return res;
    }

    private List<Integer> returnListNumber(String mapper, int number) {
        return new OutputNumerals(new MapperRegistry(mapper)).split(number);
    }

    private List<Integer> reversListNumber(String mapper, int number) {
        MapperRegistry mapperRegistry = new MapperRegistry(mapper);
        OutputNumerals outputNumerals = new OutputNumerals(mapperRegistry);
        return outputNumerals.sortDesc(returnListNumber(mapper, number));
    }


    private String dbpath(MapperType mapperType, Integer integer){
        DBMapper mapper = new DBMapper(mapperType);
        return "SELECT mappersNum, mappersNumType, mappersNumValue" +
                " FROM mappers WHERE mappersNum =" +
                integer + " and mappersNumType = " +
                "'" + mapper.getMapperType() + "'";
    }

    private List<String> selectTableColumn(MapperType mapperType, String mappers, Integer number) {
        List<Integer> revers = reversListNumber(mappers, number);
        List<String> listREaDb = new ArrayList<>();
        try {
            for (Integer integer : revers) {
                String read = dbpath(mapperType, integer);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(read);
                while (resultSet.next()) {
                    listREaDb.add(resultSet.getString("mappersNumValue"));
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return listREaDb;
    }

    public void returnResult(MapperType mapperType, String mappers, Integer number) {
        List<String> result = selectTableColumn(mapperType, mappers, number);
        for (String str : result) {
            System.out.print(str + " ");
        }
        System.out.println();
        logger.info(result + " ");
    }
}

