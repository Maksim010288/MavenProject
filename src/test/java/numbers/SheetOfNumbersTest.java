package numbers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SheetOfNumbersTest {

    SheetOfNumbers sheetOfNumbers = new SheetOfNumbers();


    @Test
    void sortAscending() {
        List<Integer> list = List.of(123, 34, 6, 87, 56);

        List<Integer> listOut = List.of(6, 34, 56, 87, 123);

        assertEquals(listOut, sheetOfNumbers.sortAscending(list));
    }

    @Test
    void reversedList(){
        List<Integer> list = List.of(123, 34, 6, 87, 56);

        List<Integer> listOut = List.of(56, 87, 6, 34, 123);

        assertEquals(listOut, sheetOfNumbers.reversedList(list));
    }

    @Test
    void theLastTwoElement() {
        List<Integer> list = List.of(123, 34, 6, 87, 56);

        List<Integer> listOut = List.of(143);

        assertEquals(listOut, sheetOfNumbers.theLastTwoElement(list));
    }

    @Test
    void if_the_list_is_empty(){
        List<Integer> list = List.of();

        List<Integer> listOut = List.of();

        assertEquals(listOut, sheetOfNumbers.theLastTwoElement(list));
    }

    @Test
    void if_the_list_one_element(){
        List<Integer> list = List.of(23);

        List<Integer> listOut = List.of(23);

        assertEquals(listOut, sheetOfNumbers.theLastTwoElement(list));
    }
}