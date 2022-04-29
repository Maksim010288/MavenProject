package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SheetOfNumbers {

    public List<Integer> sortAscending(List<Integer> list) {
        Set<Integer> sorted = new TreeSet<>(list);
        return new ArrayList<>(sorted);
    }

    public List<Integer> reversedList(List<Integer> list) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            integerList.add(list.get(i));
        }
        return integerList;
    }

    public List<Integer> theLastTwoElement(List<Integer> list) {
        int sum = list.size() > 1
                ? list.size() - 2
                : 0;
        int sum1 = list.stream().skip(sum)
                .mapToInt(Integer::intValue)
                .sum();
        if (sum1 == 0){
            return List.of();
        }
        return List.of(sum1);
    }
}


