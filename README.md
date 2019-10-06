# Coding exercises for Latitude Financial
## Description
Coding exercise as per requested by Latitude Financial

https://gist.github.com/jonog/54e46b5b1200758d222e3c4cf61baaa6

which says

Write an efficient function that takes an array of stock prices and returns the best profit I could have made from 1 purchase and 1 sale of 1 Latitude Financial stock yesterday.


Tested using java 8.

Usage: This should run build the package and run the tests.

$ `mvn package`

## Assumptions :
* Takes in an array on ints
* A array of size 1 is not considered valid input
* Share price of 0 is technically not possible.

## Design
* Design has Time Complexity : O(n), Auxiliary Space : O(1)
* I made the decision to keep the range used to get the bestResult,
which I think if it is used, will be a question often asked for anyways.
* Algorithm :
As we traverse the array, we keep the max difference ie. bestResult.
If there is a new low share price encountered, we mark it as the current low,
using this new current low to calculate subsequent results, keeping the
results if it betters the bestResult value.

@see Jadane's Algorithm.
@see https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane's_algorithm


## Possible improvements
* As a convenience feature, make a constructor take in a Collections, which
  converts it to an int array.
* have the results be a set of ranges which satisfies the max difference. Currently, it only keeps the
  first one.

## Discussion
* Least complex solution would be iterating through each share price and comparing
it to every share price in the array. However, this would have a time complexity of O(N2).
