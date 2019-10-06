# Coding exercises for Latitude Financial
## Description
Coding exercise as per requested by Latitude Financial

https://gist.github.com/jonog/54e46b5b1200758d222e3c4cf61baaa6

which says

Write an efficient function that takes an array of stock prices and returns the best profit I could have made from 1 purchase and 1 sale of 1 Latitude Financial stock yesterday.


Tested using java 8.



## Assumptions :
* Takes in an array on ints
* A array of size 1 is not considered valid input
* Share price of 0 is technically not possible.

## Design
* Design has Time Complexity : O(n), Auxiliary Space : O(1)


## Possible improvements
* As a convenience feature, make a constructor take in a Collections, which
  converts it to an int array.
* have the results be a set of ranges which satisfies the max difference. Currently, it only keeps the
  first one.
