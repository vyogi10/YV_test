package com.tst.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFizzBuzzNumberPrinter {
    private FizzBuzzNumberPrinter classUnderTest = new FizzBuzzNumberPrinter();

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @ParameterizedTest
    @MethodSource("numbersOutputProvider")
    public void testNonDivisibleNumbers(int number, String word) {
        classUnderTest.fizzBuzz(number);
        assertEquals(word, outputStreamCaptor.toString().trim());
    }

    @ParameterizedTest
    @ValueSource( ints =
            {3, 6, 9, 12, 18, 21, 24, 27, 33, 36, 39, 42, 48, 51, 54, 57, 63, 66, 69, 72, 78, 81, 84, 87, 93, 96, 99})
    public void testNumberDivisibleByThreeButNotFive(int number) {
        classUnderTest.fizzBuzz(number);
        assertEquals("Fizz", outputStreamCaptor.toString().trim());
    }

    @ParameterizedTest
    @ValueSource( ints = {5, 10, 20, 25, 35, 40, 50, 55, 65, 70, 80, 85, 95, 100})
    public void testNumberDivisibleByFiveButNotThree(int number) {
        classUnderTest.fizzBuzz(number);
        assertEquals("Buzz", outputStreamCaptor.toString().trim());
    }

    @ParameterizedTest
    @ValueSource( ints = {15, 30, 45, 60, 75, 90})
    public void testNumberDivisibleByThreeAndFive(int number) {
        classUnderTest.fizzBuzz(number);
        assertEquals("FizzBuzz", outputStreamCaptor.toString().trim());
    }

    /*Arguments for all non 5 and 3 divisible numbers with expected output string value*/
    private static Stream<Arguments> numbersOutputProvider() {
        return Stream.of(
                Arguments.of(1, "one"), Arguments.of(2, "two"), Arguments.of(4, "four"), Arguments.of(7, "seven"),
                Arguments.of(8, "eight"), Arguments.of(11, "eleven"), Arguments.of(13, "thirteen"),
                Arguments.of(14, "fourteen"), Arguments.of(16, "sixteen"), Arguments.of(17, "seventeen"),
                Arguments.of(19, "nineteen"), Arguments.of(22, "twenty two"), Arguments.of(23, "twenty three"),
                Arguments.of(26, "twenty six"), Arguments.of(28, "twenty eight"), Arguments.of(29, "twenty nine"),
                Arguments.of(31, "thirty one"), Arguments.of(32, "thirty two"), Arguments.of(34, "thirty four"),
                Arguments.of(37, "thirty seven"), Arguments.of(38, "thirty eight"), Arguments.of(41, "forty one"),
                Arguments.of(43, "forty three"), Arguments.of(44, "forty four"), Arguments.of(46, "forty six"),
                Arguments.of(47, "forty seven"), Arguments.of(49, "forty nine"), Arguments.of(52, "fifty two"),
                Arguments.of(53, "fifty three"), Arguments.of(56, "fifty six"), Arguments.of(58, "fifty eight"),
                Arguments.of(59, "fifty nine"), Arguments.of(61, "sixty one"), Arguments.of(62, "sixty two"),
                Arguments.of(64, "sixty four"), Arguments.of(67, "sixty seven"), Arguments.of(68, "sixty eight"),
                Arguments.of(71, "seventy one"), Arguments.of(73, "seventy three"), Arguments.of(74, "seventy four"),
                Arguments.of(76, "seventy six"), Arguments.of(77, "seventy seven"), Arguments.of(79, "seventy nine"),
                Arguments.of(82, "eighty two"), Arguments.of(83, "eighty three"), Arguments.of(86, "eighty six"),
                Arguments.of(88, "eighty eight"), Arguments.of(89, "eighty nine"), Arguments.of(91, "ninety one"),
                Arguments.of(92, "ninety two"), Arguments.of(94, "ninety four"), Arguments.of(97, "ninety seven"),
                Arguments.of(98, "ninety eight")
        );
    }
}
