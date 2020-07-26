# [Leaders in an array][title]

## Problem Description

Given an array of positive integers. Your task is to find the leaders in the array.
Note: An element of array is leader if it is greater than or equal to all the elements to its right side. Also, the rightmost element is always a leader. 

Detailed description can be found [here][title]

**Example:**

```
Input
	3
    6
    16 17 4 3 5 2
    5
    1 2 3 4 0
    5
    7 4 5 7 3
Output
	17 5 2
    4 0
    7 7 3
```

## Solution

```java
public static List<Integer> findLeader(int[] a) {
    int n = a.length; 
    List<Integer> candidates = new ArrayList<>();
    int i = n - 1;
    candidates.add(a[i]);
    while (i >= 0) {
        int j = i - 1;
        while (j >= 0 && a[j] < a[i])
            j--;
        if (j >= 0)
            candidates.add(a[j]);
        i = j;
    }
    Collections.reverse(candidates);
    return candidates;
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/leaders-in-an-array/0/