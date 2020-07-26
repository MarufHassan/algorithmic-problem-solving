# [728. Self Dividing Numbers][title]

## Problem Description

A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

**Example 1:**

```
Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
```

## Solution

```java
public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> ans = new ArrayList<>();
    
    for (int i = left; i <= right; i++) {
        if (check(i))
            ans.add(i);
    }
    return ans;
}

private boolean check(int n) {
    int x = n;
    while (x != 0) {
        int d = x % 10;
        if (d == 0 || n % d != 0)
            return false;
        x = x / 10;
    }
    return true;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/self-dividing-numbers/