# [Max Min][title]

## Problem Description

You will be given a list of integers, `arr` , and a single integer _k_. You must create an array of length _k_ from elements of `arr` such that its unfairness is minimized. Call that array `subarr`.

Detail description can be found [here][title].

**Example 1:**

```
    Input: 
        7
        3
        10
        100
        300
        200
        1000
        20
        30
    Output:
        20
```

**Example 2:**

```
    Input: 
        10
        4
        1
        2
        3
        4
        10
        20
        30
        40
        100
        200
    Output:
        3
```

**Example 3:**

```
    Input: 
        5
        2
        1
        2
        1
        2
        1
    Output:
        3
```

## Solution


```java
static int maxMin(int k, int[] arr) {
    Arrays.sort(arr);
    int mindiff = Integer.MAX_VALUE;
    for (int i = 0; i < (arr.length - k + 1); i++) {
        int diff = (arr[i + k - 1] - arr[i]);
        if (diff < mindiff)
            mindiff = diff;
    }
    return mindiff;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/angry-children/