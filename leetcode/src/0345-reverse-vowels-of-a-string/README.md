# [345. Reverse Vowels of a String][title]

## Problem Description

Write a function that takes a string as input and reverse only the vowels of a string.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: "hello"
Output: "holle"
```

**Example 2:**

```
Input: "leetcode"
Output: "leotcede"
```

## Solution

**Approach: Two Pointers**

```java
public String reverseVowels(String s) {
    char[] chars = s.toCharArray();
    int lo = 0, hi = s.length() - 1;
    
    while (lo < hi) {
        if (isVowel(chars[lo]) && isVowel(chars[hi])) {
            char t = chars[lo];
            chars[lo] = chars[hi];
            chars[hi] = t;
            lo++; hi--;
        }
        if (!isVowel(chars[lo]))
            lo++;
        if (!isVowel(chars[hi]))
            hi--;
    }
    return new String(chars);
}
```

**private helper methods**

```java
public boolean isVowel(char c) {
    return "AEIOUaeiou".indexOf(c) != -1;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/reverse-vowels-of-a-string/