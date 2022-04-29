package romannumbers;

import romannumbers.mappers.MapperType;
import romannumbers.mappers.NumberMapper;

import java.util.List;
import java.util.Scanner;

public class MainNumeralsMapper {
    public static void main(String[] args) {
        OutputNumerals outputNumerals = new OutputNumerals();

        Scanner scanner = new Scanner(System.in);

        ValidateRomanNumerals validateRomanNumerals = new ValidateRomanNumerals();

        MapperRegistry mapperRegistry = new MapperRegistry();

        System.out.print("Enter a number from 1 to 3999 and   - ");
        int number = scanner.nextInt();
        System.out.print("Enter(UA, EN, ROM) - ");
        String mapperType = scanner.next().toUpperCase();
        MapperType nameType = MapperType.valueOf(mapperType);
        validateRomanNumerals.validate(number, nameType);
        NumberMapper mapper = mapperRegistry.selectMapper(nameType);
        List<Integer> numbers = outputNumerals.split(number);
        if (mapper.useTeen()) {
            numbers = outputNumerals.replaceTeen(numbers);
        }
        outputNumerals.output(outputNumerals.sortDesc(numbers), mapper);
    }
}
