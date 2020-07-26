# [125. Valid Palindrome][title]

## Problem Description

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: "A man, a plan, a canal: Panama"
Output: true
```

**Example 2:**

```
Input: "race a car"
Output: false
```

## Solution

```java
public boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    
    while (left < right) {
        char leftc = Character.toLowerCase(s.charAt(left));
        char rightc = Character.toLowerCase(s.charAt(right));
        
        if (!isAlphaNum(leftc))
            left++;
        else if (!isAlphaNum(rightc)) 
            right--;
        else {
            if (leftc != rightc)
                return false;
            left++; right--;
        }
    }
    return true;
}
```

**private helper method**

```java
private boolean isAlphaNum(char c) {
    return Character.isDigit(c) || Character.isLetter(c);
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/add-strings/