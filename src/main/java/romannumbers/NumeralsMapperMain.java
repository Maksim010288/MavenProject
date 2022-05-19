package romannumbers;

import romannumbers.db.MappersDAO;
import romannumbers.db.connect.DBConfigReader;
import romannumbers.db.connect.SQLConnector;
import romannumbers.mappers.MapperRegistry;
import romannumbers.mappers.MapperType;

import java.util.Scanner;

public class NumeralsMapperMain {
    private static final Scanner scanner = new Scanner(System.in);
    public static String mapperTypeName;
    public static String name;
    public static void main(String[] args) {
        String whereARead = readString();
        int number = readNumber();
        MapperType mapperType = readMapperType();
        MapperRegistry mapperRegistry = new MapperRegistry(whereARead);
        LiveSelectionInConsole liveSelectionInConsole = new LiveSelectionInConsole();
        MappersDAO mappersDAO = createMappersDAO();
        OutputNumerals outputNumerals = new OutputNumerals(mapperRegistry);
        liveSelectionInConsole.outputInConsole(number, whereARead, outputNumerals, mappersDAO, mapperType);
    }

    private static MapperType readMapperType() {
        System.out.print("Enter(UA, EN, ROM) - ");
        mapperTypeName = scanner.next().toUpperCase();
        return MapperType.valueOf(mapperTypeName);
    }

    private static int readNumber() {
        System.out.print("Enter a number from 1 to 3999 and   - ");
        return scanner.nextInt();
    }

    private static String readString(){
        System.out.print("Enter where to read - ");
        name = scanner.nextLine();
        return name;
    }

    private static MappersDAO createMappersDAO() {
        try {
            DBConfigReader dbConfigReader = new DBConfigReader("src/main/resources/db/db.properties");
            SQLConnector connector = new SQLConnector(dbConfigReader.readDBConnectionConfig());
            return new MappersDAO(connector.getDbConnection());
        } catch (Exception e) {
            System.err.println("Could not connect");
            throw new RuntimeException(e);
        }
    }
}
