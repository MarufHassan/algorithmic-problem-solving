# [680. Valid Palindrome II][title]

## Problem Description

Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: "aba"
Output: True
```

**Example 2:**

```
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
```

## Solution

```java
public boolean validPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    if (isPalindrome(s, left, right))
        return true;
    
    while (left < right) {
        if (s.charAt(left) != s.charAt(right))
            break;
        left++; right--;
    }
    
    return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
}
```

**private helper methods**

```java
private boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
        if (s.charAt(left) != s.charAt(right))
            return false;
        left++; right--;
    }
    return true;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/valid-palindrome-ii/