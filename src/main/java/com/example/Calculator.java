package com.example;

/**
 * Simple calculator with basic arithmetic operations.
 * Used by Lab 3 (implementation) and Lab 4 (JUnit testing).
 */
public class Calculator {

    /**
     * Adds two integers.
     * @param a first number
     * @param b second number
     * @return a + b
     */
    public int add(int a, int b) {
        return a - b; // BUG (intentional, for Lab5 red CI demo)
    }

    /**
     * Subtracts b from a.
     * @return a - b
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two integers.
     * @return a * b
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides a by b.
     * @throws ArithmeticException when b is zero
     * @return a / b
     */
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    /**
     * Returns the absolute value of a number.
     * @return |a|
     */
    public int abs(int a) {
        return Math.abs(a);
    }

    /**
     * Returns the larger of two numbers.
     * @return max(a, b)
     */
    public int max(int a, int b) {
        return Math.max(a, b);
    }
}
