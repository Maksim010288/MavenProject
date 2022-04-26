package com.romannumbers;

import org.junit.jupiter.api.Test;
import romannumbers.OutputNumerals;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputNumeralsTest {

    @Test
    void inputData() {
    }

    @Test
    void splitNumberDigits() {
        OutputNumerals outputNumerals = new OutputNumerals();
        int number = 247;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(40);
        list.add(200);
        List<Integer> integerList = outputNumerals.split(number);
        assertEquals(list, integerList);
    }

    @Test
    void reverse() {
        OutputNumerals outputNumerals = new OutputNumerals();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(4);
        list.add(2);
        assertEquals(list, outputNumerals.reverse(list));
    }

    @Test
    void split() {
        OutputNumerals outputNumerals = new OutputNumerals();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(60);
        list.add(600);
        int number = 666;
        assertEquals(list, outputNumerals.split(number));
    }

    @Test
    void splitLessTheZero() {
        OutputNumerals outputNumerals = new OutputNumerals();
        int number = -247;
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> integerList = outputNumerals.split(number);
        assertEquals(list, integerList);
    }

    @Test
    void output() {
    }
}