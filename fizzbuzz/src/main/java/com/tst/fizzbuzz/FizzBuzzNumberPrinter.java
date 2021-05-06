package com.tst.fizzbuzz;

import java.util.stream.IntStream;

public class FizzBuzzNumberPrinter {
    private static final String INVALID_INPUT = "invalid input";
    /*Words for single digit number*/
    private static final String[] singleDigitWord = {
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    /*Words for number from 10 to 19*/
    private static final String[] numberWordFor10To19 = {
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "seventeen", "nineteen"};

    /*Words for numbers multiples of 10 but excluding 10*/
    private static final String[] tens = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static void main(String[] args) {
        FizzBuzzNumberPrinter app = new FizzBuzzNumberPrinter();
        app.startApp();
    }

    private void startApp() {
        for (int i = 1; i <= 100; i++) {
            fizzBuzz(i);
        }
    }

    public void fizzBuzz(int num) {
        if (num < 1 || num > 100) {
            System.out.println(INVALID_INPUT);
            return;
        }
        IntStream.rangeClosed(num, num)
            .mapToObj(i -> i % 5 == 0 ? (i % 3 == 0 ? "FizzBuzz" : "Buzz") : (i % 3 == 0 ? "Fizz" : processNumber(i)))
            .forEach(System.out::println);
    }

    private String processNumber(int num) {
        return num < 10 ? singleDigitWord[num - 1] : num < 20 ? numberWordFor10To19[num % 10] : processNumberGT20(num);
    }

    private String processNumberGT20(int number) {
        String tensPart = tens[(number / 10) - 2];
        return number % 10 == 0 ? tensPart : tensPart + " " + singleDigitWord[(number % 10) - 1];
    }
}
