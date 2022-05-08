package romannumbers.mappers.file;

import romannumbers.mappers.MapperType;
import romannumbers.mappers.NumberMapper;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesMapper implements NumberMapper {

    private final Properties properties;

    public PropertiesMapper(MapperType mapperType) {
        String filePath = "src/main/resources/" + mapperType.name().toLowerCase() + ".properties";
        try {
            properties = initializationProp(filePath);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public String map(int number) {
        return properties.getProperty(String.valueOf(number));
    }

    private Properties initializationProp(String filePath) throws Exception {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(filePath);
        properties.load(inputStream);
        return properties;
    }
}
