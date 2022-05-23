package romannumbers;

import romannumbers.db.MappersDAO;
import romannumbers.db.connect.DBConfigReader;
import romannumbers.db.connect.SQLConnector;
import romannumbers.mappers.MapperRegistry;
import romannumbers.mappers.MapperType;
import romannumbers.mappers.ReadStorageType;

import java.util.Scanner;

public class NumeralsMapperMain {
    private static final Scanner scanner = new Scanner(System.in);
    public static String mapperTypeName;
    public static String name;
    public static MappersDAO mappersDAO;

    public static void main(String[] args) {
        ReadStorageType readStorageType = readStorageType();
        int number = readNumber();
        MapperType mapperType = readMapperType();
        if (!readStorageType.equals(ReadStorageType.FILE) &&
                !readStorageType.equals(ReadStorageType.INMEMORY)) {
            mappersDAO = createMappersDAO();
        }
        MapperRegistry mapperRegistry = new MapperRegistry(readStorageType, mappersDAO);
        OutputNumerals outputNumerals = new OutputNumerals(mapperRegistry);
        outputNumerals.output(number, mapperType);
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

    private static ReadStorageType readStorageType() {
        System.out.print("Enter where to read [inMemory, file, db] - ");
        name = scanner.nextLine().toUpperCase();
        return ReadStorageType.valueOf(name);
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
