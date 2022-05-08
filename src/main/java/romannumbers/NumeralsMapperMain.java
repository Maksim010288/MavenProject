package romannumbers;

import romannumbers.mappers.MapperRegistry;
import romannumbers.mappers.MapperType;

import java.util.Scanner;

public class NumeralsMapperMain {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean inMemoryRegistry = Boolean.parseBoolean(args[0]);
        int number = readNumber();
        MapperType mapperType = readMapperType();
        OutputNumerals outputNumerals = new OutputNumerals(new MapperRegistry(inMemoryRegistry));
        outputNumerals.output(number, mapperType);
    }

    private static MapperType readMapperType() {
        System.out.print("Enter(UA, EN, ROM) - ");
        String mapperTypeName = scanner.next().toUpperCase();
        return MapperType.valueOf(mapperTypeName);
    }

    private static int readNumber() {
        System.out.print("Enter a number from 1 to 3999 and   - ");
        return scanner.nextInt();
    }
}
