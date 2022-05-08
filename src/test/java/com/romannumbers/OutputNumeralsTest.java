package com.romannumbers;

import org.junit.jupiter.api.Test;
import romannumbers.OutputNumerals;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputNumeralsTest {
    private final OutputNumerals outputNumerals = new OutputNumerals(null);

    @Test
    void splitNumberDigits() {
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
        ArrayList<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(4);
        list.add(2);
        assertEquals(list, outputNumerals.sortDesc(list));
    }

    @Test
    void split() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(60);
        list.add(600);
        int number = 666;

        assertEquals(list, outputNumerals.split(number));
    }


    @Test
    void splitLessTheZero() {
        int number = -247;
        ArrayList<Integer> list = new ArrayList<>();

        List<Integer> integerList = outputNumerals.split(number);

        assertEquals(list, integerList);
    }

    @Test
    void should_replace_teen_elements() {
        List<Integer> input = List.of(100, 1, 10, 10000);
        List<Integer> expected = List.of(10000, 100, 11);

        List<Integer> result = outputNumerals.replaceTeen(input);

        assertEquals(expected, result);
    }

    @Test
    void should_not_replace() {
        List<Integer> input = List.of(4000, 300, 50, 8);
        List<Integer> expected = List.of(4000, 300, 50, 8);

        List<Integer> result = outputNumerals.replaceTeen(input);

        assertEquals(expected, result);
    }

    @Test
    void should_not_replace_one_element() {
        List<Integer> input = List.of(1);
        List<Integer> expected = List.of(1);

        List<Integer> result = outputNumerals.replaceTeen(input);

        assertEquals(expected, result);
    }

    @Test
    void should_not_replace_if_empty() {
        List<Integer> input = List.of();
        List<Integer> expected = List.of();

        List<Integer> result = outputNumerals.replaceTeen(input);

        assertEquals(expected, result);
    }
}