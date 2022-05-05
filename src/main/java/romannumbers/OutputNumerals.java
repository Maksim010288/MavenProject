package romannumbers;

import java.io.FileInputStream;
import java.util.*;
import java.util.stream.Collectors;

public class OutputNumerals {

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
        return result.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
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

    Properties properties = new Properties();

    public Properties propertiesOutput(String filePath) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        return properties;
    }


    public void output(List<Integer> numbers, NumberMapper mapper) {
        String collect = numbers.stream()
                .map(number -> mapper.getMap().get(number))
                .collect(Collectors.joining(mapper.getDelimiter()));
        System.out.println(collect);
    }
}
