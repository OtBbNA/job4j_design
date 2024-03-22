package ru.job4j.kiss.fool;

import java.util.Locale;
import java.util.Scanner;

public class Fool {

    public static void main(String[] args) {
        System.out.println("FizzBuzz game");
        int startAt = 1;
        Scanner input = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(answer(startAt));
            startAt++;
            String answer = input.nextLine();
            if (!(answer.toLowerCase(Locale.ROOT).equals(answer(startAt).toLowerCase(Locale.ROOT)))) {
                System.out.println("Wrong. Try again.");
                startAt = 0;
            }
            startAt++;
        }
    }

    public static String answer(int startAt) {
        if (startAt % 3 == 0 && startAt % 5 == 0) {
            return "FizzBuzz";
        } else if (startAt % 3 == 0) {
            return "Fizz";
        } else if (startAt % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(startAt);
        }
    }
}