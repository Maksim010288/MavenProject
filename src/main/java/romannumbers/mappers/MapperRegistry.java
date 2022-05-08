package romannumbers.mappers;

import romannumbers.mappers.file.PropertiesMapper;
import romannumbers.mappers.memory.ENWordsMapper;
import romannumbers.mappers.memory.RomanNumeralsMapper;
import romannumbers.mappers.memory.UAWordsMapper;

import java.util.HashMap;
import java.util.Map;

public class MapperRegistry {

    private final Map<MapperType, NumberMapper> map = new HashMap<>();

    public MapperRegistry(boolean inMemory) {
        if (inMemory) {
            map.put(MapperType.ROM, new RomanNumeralsMapper());
            map.put(MapperType.UA, new UAWordsMapper());
            map.put(MapperType.EN, new ENWordsMapper());
        } else {
            map.put(MapperType.ROM, new PropertiesMapper(MapperType.ROM));
            map.put(MapperType.UA, new PropertiesMapper(MapperType.UA));
            map.put(MapperType.EN, new PropertiesMapper(MapperType.EN));
        }
    }

    public NumberMapper selectMapper(MapperType mapperType) {
        return map.get(mapperType);
    }
}
