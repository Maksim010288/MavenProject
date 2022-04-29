package numbers;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SheetOfNumbers sheetOfNumbers = new SheetOfNumbers();
        List<Integer> list = List.of(453, 68, 78, 23, 12, 78);
        List<Integer> sort = sheetOfNumbers.sortAscending(list);
        System.out.println(sort);
        List<Integer> revers = sheetOfNumbers.reversedList(sort);
        List<Integer> outList = sheetOfNumbers.theLastTwoElement(revers);
        System.out.println(outList);

        List<Integer> listOut = sheetOfNumbers.theLastTwoElement(
                sheetOfNumbers.reversedList(sheetOfNumbers.sortAscending(list)));
        System.out.println(listOut);


    }
}
