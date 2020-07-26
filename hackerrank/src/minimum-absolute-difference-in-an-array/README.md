# [Minimum Absolute Difference in an Array][title]

## Problem Description
Given an array of integers, find and print the minimum absolute difference between any two elements in the array.
Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        3
        3 -7 0
    Output:
        3
```

**Example 2:**

```
    Input: 
        10
        -59 -36 -13 1 -53 -92 -2 -96 -54 75
    Output:
        1
```

**Example 3:**

```
    Input: 
        5
        1 -3 71 68 17
    Output:
        3
```

## Solution


```java
static int minimumAbsoluteDifference(int[] arr) {
    Arrays.sort(arr);
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < arr.length; i++) {
        min = Math.min(min, Math.abs(arr[i] - arr[i-1]));
    }
    return min;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array