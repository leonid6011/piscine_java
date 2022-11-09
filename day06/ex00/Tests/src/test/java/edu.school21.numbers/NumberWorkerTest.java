package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {
    NumberWorker nw;

    @BeforeEach
    void beforeEachMethod() {
        nw = new NumberWorker();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7, 11, 13, 113, 95219})
    void isPrimeTrue(int number) {
        Assertions.assertTrue(nw.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 9, 10, 42, 169, 91239, Integer.MAX_VALUE})
    void isPrimeFalse(int number) {
        Assertions.assertFalse(nw.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -42, -1, 0, 1})
    void isPrimeExpectedExceptionTest(int number) {
        Assertions.assertThrows(IllegalNumberException.class, ()-> nw.isPrime(number));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.scv", delimiter = ',')
    void checkDigitSum(int number, int result) {
        Assertions.assertEquals(result, nw.digitsSum(number));
    }
}