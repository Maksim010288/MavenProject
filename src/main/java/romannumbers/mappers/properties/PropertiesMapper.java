package romannumbers.mappers.properties;

import java.io.FileInputStream;

public class PropertiesMapper {

    private final String uaProperties = "src/main/java/resources/ua.properties";
    private final String enProperties = "src/main/java/resources/en.properties";
    private FileInputStream uaProp;
    private FileInputStream enProp;

    public PropertiesMapper() {
        try {
            uaProp = new FileInputStream(uaProperties);
            enProp = new FileInputStream(enProperties);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public FileInputStream getUaProp() {
        return uaProp;
    }

    public FileInputStream getEnProp() {
        return enProp;
    }

    public String getUaProperties() {
        return uaProperties;
    }

    public String getEnProperties() {
        return enProperties;
    }
}
