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
        return a + b;
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

    /**
     * Entry point. With no arguments, runs a built-in demo of all
     * four basic operations (+ - * /). With three arguments
     * (operator, a, b) it computes a single operation.
     * Used by Lab 6 so the program can run inside a Docker container.
     */
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        if (args.length == 3) {
            String op = args[0];
            int a = Integer.parseInt(args[1]);
            int b = Integer.parseInt(args[2]);
            switch (op) {
                case "add":
                    System.out.println(a + " + " + b + " = " + calc.add(a, b));
                    break;
                case "subtract":
                    System.out.println(a + " - " + b + " = " + calc.subtract(a, b));
                    break;
                case "multiply":
                    System.out.println(a + " * " + b + " = " + calc.multiply(a, b));
                    break;
                case "divide":
                    try {
                        System.out.println(a + " / " + b + " = " + calc.divide(a, b));
                    } catch (ArithmeticException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                default:
                    printUsage();
                    break;
            }
        } else {
            System.out.println("Calculator is running inside the Docker container.");
            System.out.println("add(2, 3)      = " + calc.add(2, 3));
            System.out.println("subtract(8, 5) = " + calc.subtract(8, 5));
            System.out.println("multiply(3, 4) = " + calc.multiply(3, 4));
            System.out.println("divide(20, 5)  = " + calc.divide(20, 5));
            System.out.println("abs(-5)        = " + calc.abs(-5));
            System.out.println("max(9, 3)      = " + calc.max(9, 3));
        }
    }

    private static void printUsage() {
        System.out.println("Usage: java -jar calculator.jar <add|subtract|multiply|divide> <a> <b>");
    }
}
