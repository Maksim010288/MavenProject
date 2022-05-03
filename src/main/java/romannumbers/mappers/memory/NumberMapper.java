package romannumbers.mappers.memory;

import java.util.Map;

public interface NumberMapper {
    default String getDelimiter() {
        return " ";
    }

    Map<Integer, String> getMap();

    default boolean useTeen() {
        return false;
    };
}
