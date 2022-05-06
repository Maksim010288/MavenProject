package romannumbers.mappers.properties;

import romannumbers.MapperType;
import romannumbers.NumberMapper;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

public class MemoryProperties implements NumberMapper {

    String filePath;

    public MemoryProperties(MapperType mapperType, String name) {
        boolean mapType = mapperType == MapperType.UA || mapperType == MapperType.EN ||
                mapperType == MapperType.ROM;
        if (mapType) {
            this.filePath = "src/main/java/resources/" + name + ".properties";
        }
    }

    private Properties initializationProp(String str) throws Exception {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(str);
        properties.load(inputStream);
        return properties;
    }

    public void outputProp(List<Integer> list, String str, MapperType delimeter) throws Exception {
        Properties properties = initializationProp(str);
        for (Integer i : list) {
            String type = delimeter == MapperType.ROM ?
                    properties.getProperty(String.valueOf(i)) :
                    properties.getProperty(String.valueOf(i)) + " ";
            System.out.print(type);
        }
    }

    public String getFilePath() {
        return filePath;
    }
}
