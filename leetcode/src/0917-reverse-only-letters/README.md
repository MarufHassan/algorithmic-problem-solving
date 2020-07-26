# [917. Reverse Only Letters][title]

## Problem Description

Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: "ab-cd"
Output: "dc-ba"
```

**Example 2:**

```
Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
```

## Solution

```java
public String reverseOnlyLetters(String S) {
    char[] chars = S.toCharArray();
    int left = 0, right = chars.length - 1;
    
    while (left < right) {
        if (Character.isLetter(chars[left]) && Character.isLetter(chars[right])) {
            char c = chars[left];
            chars[left] = chars[right];
            chars[right] = c;
            left++; right--;
        }
        if (!Character.isLetter(chars[left]))
            left++;
        if (!Character.isLetter(chars[right]))
            right--;
    }
    return new String(chars);
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/reverse-only-letters/