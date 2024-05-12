package ru.aston;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


public class TestFactorial {
    private static Factorial f;

    @BeforeAll
    public static void setUp() {
        f = new Factorial();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2,2",
            "3,6",
            "10, 3628800"}, ignoreLeadingAndTrailingWhitespace = true)
    public void testsWithPositiveNumbers(int n, int expected) {
        Assertions.assertEquals(expected, f.factorial(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -4})
    public void testsWithNegativeNumbers(int n) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           f.factorial(n);
        });
    }

    @Test
    public void testWithZero() {
        Assertions.assertEquals(1, f.factorial(0));
    }

    @Test
    public void testWithMaxNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            f.factorial(13);
        });
    }
}
