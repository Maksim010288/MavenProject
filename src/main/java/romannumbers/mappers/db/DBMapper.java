package romannumbers.mappers.db;

import romannumbers.db.MappersDAO;
import romannumbers.mappers.MapperType;
import romannumbers.mappers.NumberMapper;

public class DBMapper implements NumberMapper {

    private MapperType mapperType;
    private MappersDAO mappersDAO;

    public DBMapper(MapperType mapperType, MappersDAO mappersDAO) {
        this.mapperType = mapperType;
        this.mappersDAO = mappersDAO;
    }

    @Override
    public String map(int number) {
       return mappersDAO.returnDataFromDb(number,mapperType);
    }
}
