package com.demo.beans;


public class Calculator {

    // Adds two numbers
    public int add(int a, int b) {
        return a + b;
    }

    // Subtracts two numbers
    public int subtract(int a, int b) {
        return a - b;
    }

    // Divides two numbers
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    public int test(){
        return 1;
    }


    public int test123(){
        return 1;
    }

    // Checks if a number is even
    public boolean isEven(int a) {
        return a % 2 == 0;
    }
}
