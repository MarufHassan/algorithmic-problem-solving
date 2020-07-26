# [976. Largest Perimeter Triangle][title]

## Problem Description

Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area, formed from 3 of these lengths.

If it is impossible to form any triangle of non-zero area, return 0.

Detailed description can be found [here][title]

**Example 1:**

```
Input: [2,1,2]
Output: 5
```

**Example 2:**

```
Input: [1,2,1]
Output: 0
```

**Example 3:**

```
Input: [3,2,3,4]
Output: 10
```

**Example 4:**

```
Input: [3,6,2,3]
Output: 8
```

## Solution

```java
public int largestPerimeter(int[] A) {
    int n = A.length;
    Arrays.sort(A);
    
    for (int i = n - 1; i >= 2; i--) {
        int a = A[i];
        int b = A[i - 1];
        int c = A[i - 2];
        if (b + c > a && a + c > b && a +  b > c)
            return a + b + c;
    }
    return 0;
}
```


## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/largest-perimeter-triangle/