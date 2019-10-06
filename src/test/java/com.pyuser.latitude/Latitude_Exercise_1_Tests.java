package com.pyuser.latitude;

import com.pyuser.latitude.exceptions.InvalidValueException;
import com.pyuser.latitude.exceptions.InsufficientDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for Latitude Latitude_Exercise_1.
 * Test names should self descriptive.
 */
public class Latitude_Exercise_1_Tests {
    Latitude_Exercise_1 _plateau;

    @BeforeEach
    public void init() {
    }

    @Test
    public void testEmptyArray() {
        int[] noSharesData = {};

        try {
            Latitude_Exercise_1 e3 = new Latitude_Exercise_1();
            int res = e3.get_max_profit(noSharesData);
            assertTrue(false, "Empty data. Should never succeed.");

        } catch (InvalidValueException| InsufficientDataException e) {
            assertTrue(e.getClass() == InsufficientDataException.class);
        }
    }

    @Test
    /**
     * Making no data as well as 1 data throw an insufficient data exception.
     * Need at least 2 for function to work.
     */
    public void testSingleDataValue() {
        int[] sharesData = {1};

        try {
            Latitude_Exercise_1 e3 = new Latitude_Exercise_1();
            int res = e3.get_max_profit(sharesData);
            assertTrue(false, "Insufficient data. Should never succeed.");
        } catch (InvalidValueException| InsufficientDataException e) {
            assertTrue(e.getClass() == InsufficientDataException.class);
        }
    }

    @Test
    /**
     * Test where share price is ZERO, which is not technically possible.
     */
    public void testZeroPriceData() {
        int[] sharesData = {1, 1, 2, 0, 3, 5};
        try {
            Latitude_Exercise_1 e3 = new Latitude_Exercise_1();
            int res = e3.get_max_profit(sharesData);
            assertTrue(false, "Empty data. Should never succeed.");

        } catch (InvalidValueException| InsufficientDataException e) {
            assertTrue(e.getClass() == InvalidValueException.class);
        }
    }

    @Test
    /**
     * Test where share price is negative, which is not technically possible.
     */
    public void testNegativeSharePrice() {
        int[] sharesData = {1, 3, 5, 2, -1, 2, 3, 4};
        try {
            Latitude_Exercise_1 e3 = new Latitude_Exercise_1();
            int res = e3.get_max_profit(sharesData);
            assertTrue(false, "Negative share price. Should never succeed.");

        } catch (InvalidValueException| InsufficientDataException e) {
            assertTrue(e.getClass() == InvalidValueException.class);
        }
    }

    @Test
    public void testPriceDescending() {
        int[] sharesData = {100, 95, 90, 85, 80, 75, 70, 65, 60};
        try {
            Latitude_Exercise_1 e3 = new Latitude_Exercise_1();
            int res = e3.get_max_profit(sharesData);
            assert(res == 0);
            assert(e3.getBestEnd() == 0);
            assert(e3.getBestStart() == 0);

        } catch (InvalidValueException| InsufficientDataException e) {
            assertTrue(false, "Should never succeed.");
        }
    }


    @Test
    public void testPriceAscending() {
        int pricePeak = 80;
        // IntStream.range(0, 100/3).map(i -> i*3)
        List<Integer> sharesList = IntStream.rangeClosed(60, 80)
                .boxed().collect(Collectors.toList());
        int[] sharesData = sharesList.stream().mapToInt(i -> i).toArray();

        try {
            Latitude_Exercise_1 e3 = new Latitude_Exercise_1();
            int res = e3.get_max_profit(sharesData);
            assert(res == 20);
            assert(e3.getBestStart() == 0);
            assert(e3.getBestEnd() == sharesData.length - 1);
        } catch (InvalidValueException| InsufficientDataException e) {
            assertTrue(false, "Should never succeed.");
        }
    }



    @Test
    /**
     * test when the lowest price is not part of solution
     * Lower price is 1. Biggest range is 29 at positions 1 and 4).
     */
    public void testLowestPriceIsNotPartOfSolution() {
        int[] sharesData = {12, 11, 17, 20, 40, 12, 5, 3, 8, 22, 18, 9, 2, 1, 3 , 2, 15};
        try {
            Latitude_Exercise_1 e3 = new Latitude_Exercise_1();
            int res = e3.get_max_profit(sharesData);
            assert(res == 29);
            assert(e3.getBestStart() == 1);
            assert(e3.getBestEnd() == 4);  // cos index start=0
        } catch (InvalidValueException| InsufficientDataException e) {
            assertTrue(false, "Should never succeed.");
        }
    }

    @Test
    /**
     * test when the highest price is not part of solution
     * Highest price is 40. Biggest range is for prices [2, 32] 30 at positions 7 and 13).
     */
    public void testHighestPriceIsNotPartOfSolution() {
        int[] sharesData = {12, 11, 17, 20, 40, 12, 5, 2, 8, 22, 18, 9, 3, 32, 1, 3 , 2, 15};
        try {
            Latitude_Exercise_1 e3 = new Latitude_Exercise_1();
            int res = e3.get_max_profit(sharesData);
            assert(res == 30);
            assert(e3.getBestStart() == 7);
            assert(e3.getBestEnd() == 13);  // cos index start=0
        } catch (InvalidValueException| InsufficientDataException e) {
            assertTrue(false, "Should never succeed.");
        }
    }

    @Test
    /**
     * Usual problematic areas are where data is at the start and at the end.
     * Testing this is not the case here.
     */
    public void testSolutionIsAtArrayExtremes() {
        int[] sharesData = {1, 12, 11, 17, 20, 20, 12, 5, 2, 8, 22, 18, 9, 3, 32, 1, 3 , 2, 40};
        try {
            Latitude_Exercise_1 e3 = new Latitude_Exercise_1();
            int res = e3.get_max_profit(sharesData);
            assert(res == 39);
            assert(e3.getBestStart() == 0);
            assert(e3.getBestEnd() == sharesData.length - 1);  // cos index start=0
        } catch (InvalidValueException| InsufficientDataException e) {
            assertTrue(false, "Should never succeed.");
        }
    }
}