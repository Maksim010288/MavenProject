package romannumbers;

import java.util.Map;

public interface NumberMapper {
    default String getDelimiter() {
        return " ";
    }

    default Map<Integer, String> getMap(){
        return null;
    }

    default boolean useTeen() {
        return false;
    };
}
