package com.romannumbers.mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import romannumbers.mappers.ENWordsMapper;

class ENWordsMapperTest {

    @Test
    void getMap() {
        ENWordsMapper enWordsMapper = new ENWordsMapper();
        Assertions.assertEquals(enWordsMapper.map, enWordsMapper.getMap());
    }
}