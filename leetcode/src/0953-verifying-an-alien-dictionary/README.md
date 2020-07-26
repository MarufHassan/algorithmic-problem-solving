# [953. Verifying an Alien Dictionary][title]

## Problem Description

Given a sequence of `words` written in the alien language, and the `order` of the alphabet, return `true` if and only if the given `words` are sorted lexicographicaly in this alien language. Detailed description can be found [here][title]

**Example 1:**

```
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
```

**Example 2:**

```
Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
```

**Example 3:**

```
Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character.
```

## Solution


```java
public boolean isAlienSorted(String[] words, String order) {
    for (int i = 0; i < words.length - 1; i++) {
        int cmp = compare(words[i], words[i + 1], order);
        if (cmp > 0)
            return false;
    }
    return true;
}
```

**Helper Method**
```java
public int compare(String a, String b, String order) {
    for (int i = 0; i < a.length() && i < b.length(); i++) {
        int m = order.indexOf(a.charAt(i));
        int n = order.indexOf(b.charAt(i));
        
        if (m != n)         return m - n;
    }
    return a.length() - b.length();
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/verifying-an-alien-dictionary/