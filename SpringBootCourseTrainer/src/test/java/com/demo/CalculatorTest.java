package com.demo;



import com.demo.beans.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // optional: order tests
class CalculatorTest {

    private Calculator calculator;

    // Runs once before all tests
    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Starting Calculator tests...");
    }

    // Runs before each test
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Setting up before test");
    }

    // Runs after each test
    @AfterEach
    void tearDown() {
        System.out.println("Cleaning up after test");
    }

    // Runs once after all tests
    @AfterAll
    static void afterAllTests() {
        System.out.println("Finished all Calculator tests");
    }

    // ✅ Test addition
    @Test
    @Order(1)
    void testAdd() {
        int result = calculator.add(5, 3);
        assertEquals(8, result, "5 + 3 should be 8");
    }

    // ✅ Test subtraction
    @Test
    @Order(2)
    void testSubtract() {
        int result = calculator.subtract(10, 4);
        assertEquals(6, result, "10 - 4 should be 6");
    }

    // ✅ Test division success
    @Test
    @Order(3)
    void testDivide() {
        int result = calculator.divide(20, 4);
        assertEquals(5, result);
    }

    // ✅ Test division by zero (exception)
    @Test
    @Order(4)
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    // ✅ Test even check
    @Test
    @Order(5)
    void testIsEven() {
        assertTrue(calculator.isEven(8));
        assertFalse(calculator.isEven(7));
    }
}
