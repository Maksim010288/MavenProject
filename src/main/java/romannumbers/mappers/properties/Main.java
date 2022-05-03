package romannumbers.mappers.properties;

import romannumbers.OutputNumerals;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        PropertiesMapper propertiesMapper = new PropertiesMapper();
        OutputNumerals outputNumerals = new OutputNumerals();
        List<Integer> list = List.of(40, 3);
        outputNumerals.outProperties(propertiesMapper, list);
    }
}
