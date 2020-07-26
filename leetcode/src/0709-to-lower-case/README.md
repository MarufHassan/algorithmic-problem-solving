# [709. To Lower Case][title]

## Problem Description

Implement function `ToLowerCase()` that has a string parameter `str`, and returns the same string in lowercase.

**Example 1:**

```
Input: "Hello"
Output: "hello"
```

**Example 2:**

```
Input: "here"
Output: "here"
```

**Example 3:**

```
Input: "LOVELY"
Output: "lovely"
```

## Solution


```java
public String toLowerCase(String str) {
    char[] s = str.toCharArray();
    
    for (int i = 0; i < s.length; i++) {
        if (s[i] >= 'A' && s[i] <= 'Z')
            s[i] = (char) ((s[i] - 'A') + 'a');
    }
    return new String(s);
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/to-lower-case/