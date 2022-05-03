package romannumbers;

import romannumbers.mappers.memory.MapperType;
import romannumbers.mappers.memory.NumberMapper;
import romannumbers.mappers.properties.PropertiesMapper;

import java.util.List;
import java.util.Scanner;

public class MainNumeralsMapper {
    public static void main(String[] args) {
        OutputNumerals outputNumerals = new OutputNumerals();

        Scanner scanner = new Scanner(System.in);

        ValidateRomanNumerals validateRomanNumerals = new ValidateRomanNumerals();

        InMemoryMapper mapperRegistry = new InMemoryMapper();

        PropertiesMapper propertiesMapper = new PropertiesMapper();

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
        //outputNumerals.output(outputNumerals.sortDesc(numbers), mapper);
        try {
            outputNumerals.outProperties(propertiesMapper, numbers);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
