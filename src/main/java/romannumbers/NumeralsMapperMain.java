package romannumbers;

import romannumbers.mappers.MapperRegistry;
import romannumbers.mappers.MapperType;
import romannumbers.mappers.databases.SQLRequests;
import romannumbers.mappers.databases.connect.DBConnectionData;
import romannumbers.mappers.databases.connect.SQLConnect;

import java.util.Scanner;

public class NumeralsMapperMain {
    private static final Scanner scanner = new Scanner(System.in);
   public static String mapperTypeName;

    public static void main(String[] args) {
        boolean inMemoryRegistry = Boolean.parseBoolean(args[0]);
        int number = readNumber();
        MapperType mapperType = readMapperType();
        SQLRequests sqlRequests = readSQLRequest();
        OutputNumerals outputNumerals = new OutputNumerals(new MapperRegistry(inMemoryRegistry));
        //outputNumerals.output(number, mapperType);
        assert sqlRequests != null;
        sqlRequests.outputResult(outputNumerals.split(number), mapperTypeName);
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

    private static SQLRequests readSQLRequest() {
        DBConnectionData dbConnectionData = null;
        try {
            return new SQLRequests(new SQLConnect(dbConnectionData).getDbConnect());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
