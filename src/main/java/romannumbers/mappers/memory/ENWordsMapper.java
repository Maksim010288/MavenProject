package romannumbers.mappers.memory;

import romannumbers.mappers.NumberMapper;

import java.util.HashMap;
import java.util.Map;

public class ENWordsMapper implements NumberMapper {

   public final Map<Integer, String> map = new HashMap<>();

    public ENWordsMapper() {
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Fourty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        map.put(100, "One Hundred");
        map.put(200, "Twu Hundred");
        map.put(300, "Three Hundred");
        map.put(400, "Four Hundred");
        map.put(500, "Fife Hundred");
        map.put(600, "Six Hundred");
        map.put(700, "Seven Hundred");
        map.put(800, "Eight Hundred");
        map.put(900, "Nine Hundred");
        map.put(1000, "One Thousand");
        map.put(2000, "Two Thousand");
        map.put(3000, "Three Thousand");
    }

    @Override
    public String map(int number) {
        return map.get(number);
    }

}
