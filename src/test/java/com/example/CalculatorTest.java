package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * JUnit 5 test cases for the Calculator class (Lab 4).
 * These tests are executed automatically by GitHub Actions in Lab 5.
 */
public class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void testAdd() {
        Assertions.assertEquals(5, calc.add(2, 3));
        Assertions.assertEquals(0, calc.add(-2, 2));
    }

    @Test
    void testSubtract() {
        Assertions.assertEquals(3, calc.subtract(8, 5));
        Assertions.assertEquals(-2, calc.subtract(3, 5));
    }

    @Test
    void testMultiply() {
        Assertions.assertEquals(12, calc.multiply(3, 4));
        Assertions.assertEquals(0, calc.multiply(0, 9));
    }

    @Test
    void testDivide() {
        Assertions.assertEquals(4, calc.divide(20, 5));
        Assertions.assertEquals(3, calc.divide(7, 2));
    }

    @Test
    void testDivideByZeroThrowsException() {
        Assertions.assertThrows(ArithmeticException.class, () -> calc.divide(10, 0));
    }

    @Test
    void testAbs() {
        Assertions.assertEquals(5, calc.abs(-5));
        Assertions.assertEquals(5, calc.abs(5));
    }

    @Test
    void testMax() {
        Assertions.assertEquals(9, calc.max(9, 3));
        Assertions.assertEquals(7, calc.max(-1, 7));
    }
}
