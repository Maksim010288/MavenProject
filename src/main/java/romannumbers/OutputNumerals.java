package romannumbers;

import romannumbers.mappers.MapperType;
import romannumbers.mappers.NumberMapper;
import romannumbers.mappers.UAWordsMapper;

import java.util.*;
import java.util.stream.Collectors;

public class OutputNumerals {

    private final Scanner scanner = new Scanner(System.in);

    private final ValidateRomanNumerals validateRomanNumerals = new ValidateRomanNumerals();

    private final MapperRegistry mapperRegistry = new MapperRegistry();

    UAWordsMapper uaWordsMapper = new UAWordsMapper();

    public void inputData() {
        System.out.print("Enter a number from 1 to 3999 and   - ");
        int number = scanner.nextInt();
        System.out.print("Enter(UA, EN, ROM) - ");
        String mapperType = scanner.next().toUpperCase();
        MapperType nameType = MapperType.valueOf(mapperType);
        validateRomanNumerals.validate(number, nameType);
        output(split(number), uaWordsMapper);
        output(splitNumberDigits(number), mapperRegistry.selectMapper(nameType));
    }

    public void output (ArrayList<Integer> reversed, UAWordsMapper uaWordsMapper){
        List<Integer> revers = reverse(reversed);
        for (Integer i : revers) {
            System.out.println(uaWordsMapper.getMap().get(i));
        }
    }


    public List<Integer> splitNumberDigits(int number) {
        ArrayList<Integer> result = split(number);
        return reverse(result);
    }

    public List<Integer> reverse(ArrayList<Integer> result) {
        return result.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public ArrayList<Integer> split(int number) {
        ArrayList<Integer> result = new ArrayList<>();
        int x, y, count = 1;
        for (int j = number; j > 0; j = j / 10) {
            x = j % 10;
            y = x * count;
            result.add(y);
            count = count * 10;
        }
        return result;
    }

    public void output(List<Integer> numbers, NumberMapper mapper) {
        String collect = numbers.stream()
                .map(number -> mapper.getMap().get(number))
                .collect(Collectors.joining(mapper.getDelimiter()));
        System.out.println(collect);
    }
}
