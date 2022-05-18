package romannumbers.mappers.db;

import romannumbers.mappers.MapperType;
import romannumbers.mappers.NumberMapper;

import java.util.List;

public class DBMapper implements NumberMapper {

    private MapperType mapperType;

    public DBMapper(MapperType mapperType) {
        this.mapperType = mapperType;
    }

    public MapperType getMapperType() {
        return mapperType;
    }

    @Override
    public String map(int number) {
        return String.valueOf(number);
    }
}
