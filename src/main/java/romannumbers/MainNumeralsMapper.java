package romannumbers;

import romannumbers.mappers.properties.MemoryProperties;

import java.util.List;
import java.util.Scanner;

public class MainNumeralsMapper {
    public static void main(String[] args) {
        OutputNumerals outputNumerals = new OutputNumerals();

        Scanner scanner = new Scanner(System.in);

        ValidateRomanNumerals validateRomanNumerals = new ValidateRomanNumerals();

        RegistryMamoryMapper mapperRegistry = new RegistryMamoryMapper();

        MemoryProperties memoryProperties = new MemoryProperties();

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
        try {
            memoryProperties.outputProp(numbers, memoryProperties.getFilePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
