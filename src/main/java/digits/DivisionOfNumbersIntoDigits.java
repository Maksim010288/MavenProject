package digits;

public class DivisionOfNumbersIntoDigits {

    public void divisionOfNumbersIntoDigits(int number) {
        int x;
        int count = 1;
        for (int i = number; i > 0; i = i / 10) {
            x = i % 10;
            System.out.println(x * count);
            count = count * 10;
        }
    }
}

