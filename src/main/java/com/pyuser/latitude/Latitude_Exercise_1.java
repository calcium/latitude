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


    public int get_max_profit(int[] sharePrices) throws InvalidValueException, InsufficientDataException {
        int numSharePrices = sharePrices.length;
        if (numSharePrices < 2) {
            throw new InsufficientDataException(String.format("No data in provided list."));
        }

        int current_diff = 0;
        int current_start = 0;

        for (int idx = 0; idx < numSharePrices; ++idx) {
            int sharePrice = sharePrices[idx];
            if (sharePrice <= 0 ) {
                throw new InvalidValueException(String.format("Invalid share price at position(%d)", idx));
            }
            // new low for the day. mark it.
            if (sharePrice < sharePrices[current_start]) {
                current_start = idx;  // dont do anything else.
            } else {
//                # Extend the existing sequence with the current element
                current_diff = sharePrice - sharePrices[current_start];
            }

            if (current_diff > bestResult) {
                bestResult = current_diff;
                bestStart = current_start;
                bestEnd = idx;
            }
        }
        return bestResult;
    }
}