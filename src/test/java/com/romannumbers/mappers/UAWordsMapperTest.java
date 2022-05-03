package com.romannumbers.mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import romannumbers.mappers.memory.UAWordsMapper;

class UAWordsMapperTest {

    @Test
    void getMap() {
        UAWordsMapper uaWordsMapper = new UAWordsMapper();
        Assertions.assertEquals(uaWordsMapper.map, uaWordsMapper.getMap());
    }
}