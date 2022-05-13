package romannumbers;

import romannumbers.mappers.MapperRegistry;
import romannumbers.mappers.MapperType;
import romannumbers.mappers.NumberMapper;
import romannumbers.mappers.databases.SQLRequests;
import romannumbers.mappers.databases.connect.DBConnection;
import romannumbers.mappers.databases.connect.DBConnectionData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class OutputNumerals {

    private final MapperRegistry mapperRegistry;
    private final ValidateRomanNumerals validator;

    public OutputNumerals(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
        this.validator = new ValidateRomanNumerals();
    }

    public void output(int number, MapperType mapperType) {
        validator.validate(number, mapperType);
        List<Integer> numbers = split(number);
        if (mapperType.isUseTeen()) {
            numbers = replaceTeen(numbers);
        }
        NumberMapper mapper = mapperRegistry.selectMapper(mapperType);
        String collect = numbers.stream()
                .map(mapper::map)
                .collect(joining(mapperType.getDelimiter()));
        System.out.println(collect);
    }

    public List<Integer> split(int number) {
        List<Integer> result = new ArrayList<>();
        int x, y, count = 1;
        for (int j = number; j > 0; j = j / 10) {
            x = j % 10;
            y = x * count;
            result.add(y);
            count = count * 10;
        }
        return result;
    }

    public List<Integer> replaceTeen(List<Integer> numbers) {
        List<Integer> sorted = sortDesc(numbers);
        int skip = numbers.size() > 1
                ? numbers.size() - 2
                : 0;
        int sum = sorted.stream()
                .skip(skip)
                .mapToInt(Integer::intValue)
                .sum();
        if (sum > 10 && sum < 20) {
            sorted.add(sum);
            sorted.removeIf(i -> i == 10 || i < 10);
        }
        return sorted;
    }

    public List<Integer> sortDesc(List<Integer> result) {
        return result.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

}
