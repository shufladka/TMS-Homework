package org.tms.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompareServiceTest {

    // тест на совпадение
    @Test
    public void testMatch() {

        // Given
        CompareService compareService = new CompareService();
        String value1 = "Substring";
        String value2 = "sub";

        // When
        int result = compareService.compare(value1, value2);

        // Then
        Assertions.assertEquals(0, result);
    }

    // тест на несовпадение
    @Test
    public void testMisMatch() {

        // Given
        CompareService compareService = new CompareService();
        String value1 = "Substring";
        String value2 = "test";

        // When
        int result = compareService.compare(value1, value2);

        // Then
        Assertions.assertEquals(-1, result);
    }

    // тест на зависимость к регистру
    @Test
    public void testWithoutCase() {

        // Given
        CompareService compareService = new CompareService();
        String value1 = "Substring";
        String value2 = "sub";

        // When
        int result = compareService.compare(value1.toUpperCase(), value2);

        // Then
        Assertions.assertEquals(0, result);
    }
}