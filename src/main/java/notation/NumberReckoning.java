package notation;

public class NumberReckoning {
    HexadecimalLetterMap letterMap = new HexadecimalLetterMap();

    public Object hexadecimalNumberSystem(int number) {
        int divider = number / 16;
        System.out.println(divider);
        int remainder = number % 16;
        System.out.println(remainder);
        if (remainder < 9) {
            return divider + "" + remainder;
        } else if (divider > 9 && remainder < 15) {
            return letterMap.hexadecimalLetters.get(divider) + ""
                    + letterMap.hexadecimalLetters.get(remainder);
        }
        return "";
    }

    public void outputHexadecimalNumberSystem(int number) {
        Object output = hexadecimalNumberSystem(number);
        System.out.println(output);
    }
}
