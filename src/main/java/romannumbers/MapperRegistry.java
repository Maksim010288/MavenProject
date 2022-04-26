package romannumbers;

import romannumbers.mappers.*;

import java.util.HashMap;
import java.util.Map;

public class MapperRegistry {

    private final NumberMapper romanMapper = new RomanNumeralsMapper();
    private final NumberMapper uaWordsMapper = new UAWordsMapper();
    private final NumberMapper usaWordsMapper = new ENWordsMapper();

    private final Map<MapperType, NumberMapper> map = new HashMap<>();

    public MapperRegistry() {
        map.put(MapperType.ROM, romanMapper);
        map.put(MapperType.UA, uaWordsMapper);
        map.put(MapperType.EN, usaWordsMapper);
    }

    private NumberMapper getRomanMapper() {
        return romanMapper;
    }

    private NumberMapper getUaWordsMapper() {
        return uaWordsMapper;
    }

    private NumberMapper getEnWordsMapper() {
        return usaWordsMapper;
    }

    public Map<MapperType, NumberMapper> getMap() {
        return map;
    }

    public NumberMapper selectMapper(MapperType nameType) {
        return map.get(nameType);
    }
}
