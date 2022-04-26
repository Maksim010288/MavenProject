package guessinggame;

import java.util.Scanner;

public class GuessingGame {

    public int randomNumber = (int) (Math.random() * 10);
    Scanner scanner = new Scanner(System.in);

    private void validData(int number) {
        if (number < 0 || number > 10) {
            throw new IllegalArgumentException();
        }
    }

    public void inputNumber() {
        System.out.println("Введите число от 0 до 10");
        int number = scanner.nextInt();
        validData(number);
        outputNumber(number);
    }

    private void outputNumber(int number) {
        if (randomNumber == number) {
            System.out.println("Ви вгадали!!! загадане число - " + randomNumber);
        } else {
            inputNumber();
        }
    }
}
