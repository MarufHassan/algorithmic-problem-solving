# [9. Palindrome Number][title]

## Problem Description

Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

**Example 1:**

```
Input: 121
Output: true
```

**Example 2:**

```
Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
```

**Example 3:**

```
Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
```

## Solution


```java
public boolean isPalindrome(int x) {
    if (x < 0) return false; // negative number can never be palindrome

    // number with last digit zero can never be palindrome except 0.
    if (x % 10 == 0 && x != 0) return false;

    int reverse = 0;
    while (x > reverse) {
        int pop = x % 10;
        reverse = (reverse * 10) + pop;
        x /= 10;
    }
    return (x == reverse) || (x == reverse / 10) ;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

```java
class Solution {
    public boolean isPalindrome(int x) {
        /* see previous code */
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        assert s.isPalindrome(121);
        assert s.isPalindrome(1232);
        assert !s.isPalindrome(-121);
        assert !s.isPalindrome(10);

        // edge cases
        assert s.isPalindrome(0);
        assert s.isPalindrome(00);
        assert s.isPalindrome(1);
        assert s.isPalindrome(11);
        assert s.isPalindrome(22222222);
        assert !s.isPalindrome(2147483647);
    }
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/palindrome-number/