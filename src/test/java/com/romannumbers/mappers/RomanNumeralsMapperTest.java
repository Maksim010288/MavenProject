package com.romannumbers.mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import romannumbers.mappers.memory.RomanNumeralsMapper;

class RomanNumeralsMapperTest {

    @Test
    void getMap() {
        RomanNumeralsMapper romanNumeralsMapper = new RomanNumeralsMapper();
        Assertions.assertEquals(romanNumeralsMapper.map, romanNumeralsMapper.getMap());
    }
}