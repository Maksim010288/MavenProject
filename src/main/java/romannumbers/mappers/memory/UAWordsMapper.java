package romannumbers.mappers.memory;

import romannumbers.NumberMapper;

import java.util.HashMap;
import java.util.Map;

public class UAWordsMapper implements NumberMapper {

    public final Map<Integer, String> map = new HashMap<>();

    public UAWordsMapper() {
        map.put(1, "Один");
        map.put(2, "Два");
        map.put(3, "Три");
        map.put(4, "Чотири");
        map.put(5, "Пять");
        map.put(6, "Шість");
        map.put(7, "Сім");
        map.put(8, "Вісім");
        map.put(9, "Девять");
        map.put(10, "Десять");
        map.put(11, "Одинадцять ,");
        map.put(12, "Дванадцять");
        map.put(13, "Тринадцять");
        map.put(14, "Чотирнадцять");
        map.put(15, "Пятнадцять");
        map.put(16, "Шістнадцять");
        map.put(17, "Сімнадцять");
        map.put(18, "Вісімнадцять");
        map.put(19, "Дивятнадцять");
        map.put(20, "Двадцять");
        map.put(30, "Тридцять");
        map.put(40, "Сорок");
        map.put(50, "Пятдесять");
        map.put(60, "Шістдесять");
        map.put(70, "Сімдесять");
        map.put(80, "Вісімдесять");
        map.put(90, "Девяносто");
        map.put(100, "Сто");
        map.put(200, "Двісті");
        map.put(300, "Триста");
        map.put(400, "Чотириста");
        map.put(500, "Пятсот");
        map.put(600, "Шістсот");
        map.put(700, "Сімсот");
        map.put(800, "ВІсімсот");
        map.put(900, "Девятсот");
        map.put(1000, "Одна тисяча");
        map.put(2000, "Дві тисячі");
        map.put(3000, "Три тисячі");
        map.put(4000, "Чотири тисячі");
        map.put(5000, "Пять тисяч");
        map.put(6000, "Шість тисяч");
        map.put(7000, "Сім тисяч");
        map.put(8000, "Вісім тисяч");
        map.put(9000, "Девять тисяч");
        map.put(10000, "Десять тисяч");

    }

    @Override
    public Map<Integer, String> getMap() {
        return map;
    }

    @Override
    public boolean useTeen() {
        return true;
    }
}
