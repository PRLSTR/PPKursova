package com.touragency;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.sql.Connection;
/**
 * Unit-тест
 * перевіряється робота з'єднання з базою даних через DBConnection
 */
public class AppTest extends TestCase {
    /**
     * конструктор тесту який приймає назву тесту
     */
    public AppTest(String testName) {
        super(testName);
    }
    /**
     * створює набір тестів TestSuite
     * у цьому випадку всі методи test*() з цього класу
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }
    /**
     * тест, чи встановлюється з'єднання з бд:
     * метод DBConnection.getConnection() не повертає null
     * та з'єднання не має закриватися одразу після отримання
     * якщо якийсь пункт не виконується, то тест виб'є помилку.
     */
    public void testDatabaseConnection() {
        try {
            // отримання з'єднання з бд
            Connection conn = DBConnection.getConnection();
            // перевірка що з'єднання не null та відкрите
            assertNotNull("Connection should not be null", conn);
            assertFalse("Connection should not be closed", conn.isClosed());
            // закриття з'єднання після тесту
            conn.close();
        } catch (Exception e) {
            // якщо щось не так - вибиває помилку
            fail("Exception during DB connection: " + e.getMessage());
        }
    }
}
