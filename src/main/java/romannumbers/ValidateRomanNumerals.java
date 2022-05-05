package romannumbers;

public class ValidateRomanNumerals {

    private static final int MAX_ROMAN_NUM = 3999;

    public void validate(int number, MapperType nameType) {
        if (MapperType.ROM.equals(nameType) &&
                (number < 1 || number > MAX_ROMAN_NUM)) {
            throw new IllegalArgumentException();
        }
    }
}
