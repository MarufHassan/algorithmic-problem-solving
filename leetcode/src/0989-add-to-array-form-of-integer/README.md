# [989. Add to Array-Form of Integer][title]

## Problem Description

For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  For example, if X = 1231, then the array form is [1,2,3,1].

Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.

**Example 1:**

```
Input: A = [1,2,0,0], K = 34
Output: [1,2,3,4]

Explanation: 1200 + 34 = 1234
```

**Example 2:**

```
Input: A = [2,7,4], K = 181
Output: [4,5,5]

Explanation: 274 + 181 = 455
```

## Solution


```java
public List<Integer> addToArrayForm(int[] A, int K) {
    LinkedList<Integer> ans = new LinkedList<>();
    
    int i = A.length - 1, c = 0;
    while (i >= 0 || K > 0) {
        int d1 = (i >= 0) ? A[i] : 0;
        int d2 = K % 10;
        int r = d1 + d2 + c;
        ans.addFirst(r % 10);
        c = r / 10;
        i--; K /= 10;
    }
    if (c > 0)
        ans.addFirst(c);
    return ans;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/add-to-array-form-of-integer/