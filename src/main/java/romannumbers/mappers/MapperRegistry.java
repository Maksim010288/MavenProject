package romannumbers.mappers;

import romannumbers.db.MappersDAO;
import romannumbers.mappers.db.DBMapper;
import romannumbers.mappers.file.PropertiesMapper;
import romannumbers.mappers.memory.ENWordsMapper;
import romannumbers.mappers.memory.RomanNumeralsMapper;
import romannumbers.mappers.memory.UAWordsMapper;

import java.util.HashMap;
import java.util.Map;

public class MapperRegistry {

    private final Map<MapperType, NumberMapper> map = new HashMap<>();

    public MapperRegistry(ReadStorageType storageType, MappersDAO mappersDAO) {
        switch (storageType) {
            case INMEMORY:
                map.put(MapperType.ROM, new RomanNumeralsMapper());
                map.put(MapperType.UA, new UAWordsMapper());
                map.put(MapperType.EN, new ENWordsMapper());
                break;
            case FILE:
                map.put(MapperType.ROM, new PropertiesMapper(MapperType.ROM));
                map.put(MapperType.UA, new PropertiesMapper(MapperType.UA));
                map.put(MapperType.EN, new PropertiesMapper(MapperType.EN));
                break;
            case DB:
                map.put(MapperType.ROM, new DBMapper(MapperType.ROM, mappersDAO));
                map.put(MapperType.EN, new DBMapper(MapperType.EN, mappersDAO));
                map.put(MapperType.UA, new DBMapper(MapperType.UA, mappersDAO));
                break;
        }
    }

    public NumberMapper selectMapper(MapperType mapperType) {
        return map.get(mapperType);
    }
}
