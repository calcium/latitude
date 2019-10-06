package com.pyuser.latitude;

import com.pyuser.latitude.exceptions.InvalidValueException;
import com.pyuser.latitude.exceptions.InsufficientDataException;

/**
 * Latitude financial coding challenge.
 * Gets the biggest difference in an array of integers
 * maximise array[Y] - array[X] where Y > X
 */
public class Latitude_Exercise_1 {
    private int bestResult = 0;  // best biggest diff
    private int bestStart = 0;   // index of range start of solution
    private int bestEnd = 0;     // index of range end of solution

    public int getBestResult() {
        return bestResult;
    }

    public int getBestStart() {
        return bestStart;
    }

    public int getBestEnd() {
        return bestEnd;
    }

    /**
     * Algorithm :
     * As we traverse the array, we keep the max difference ie. bestResult.
     * If there is a new low share price encountered, we mark it as the current low,
     * using this new current low to calculate subsequent results, keeping the
     * results if it betters the bestResult value.
     * @see Jadane's Algorithm.
     * @see https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane's_algorithm
     *
     * @param sharePrices
     * @return bestResult
     * @throws InvalidValueException
     * @throws InsufficientDataException
     */
    public int get_max_profit(int[] sharePrices) throws InvalidValueException, InsufficientDataException {
        int numSharePrices = sharePrices.length;
        if (numSharePrices < 2) {
            throw new InsufficientDataException(String.format("No data in provided list."));
        }

        int currentDiff = 0;
        int currentStart = 0;

        for (int idx = 0; idx < numSharePrices; ++idx) {
            int sharePrice = sharePrices[idx];
            if (sharePrice <= 0 ) {
                throw new InvalidValueException(String.format("Invalid share price at position(%d)", idx));
            }
            // new low for the day. mark it.
            if (sharePrice < sharePrices[currentStart]) {
                currentStart = idx;  // dont do anything else.
            } else {
                currentDiff = sharePrice - sharePrices[currentStart];
            }

            if (currentDiff > bestResult) {
                bestResult = currentDiff;
                bestStart = currentStart;
                bestEnd = idx;
            }
        }
        return bestResult;
    }
}