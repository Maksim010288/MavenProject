package romannumbers.mappers.properties;

import romannumbers.MapperType;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

public class MemoryProperties {

    String filePath;

    public MemoryProperties(MapperType mapperType) {
        if (mapperType == MapperType.EN) {
            this.filePath = "src/main/java/resources/en.properties";
        }else {
            this.filePath = "src/main/java/resources/ua.properties";
        }
    }

    private Properties InitializationProp(String str) throws Exception {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(str);
        properties.load(inputStream);
        return properties;
    }

    public void outputProp(List<Integer> list, String str) throws Exception{
        Properties properties = this.InitializationProp(str);
        for (Integer i : list){
            System.out.print(properties.getProperty(String.valueOf(i)) + " ");
        }
    }

    public String getFilePath(){
        return filePath;
    }
}
