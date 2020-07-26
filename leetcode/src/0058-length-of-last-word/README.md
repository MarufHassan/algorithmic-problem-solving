# [58. Length of Last Word][title]

## Problem Description

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: "Hello World"
Output: 5
```

## Solution

```java
public int lengthOfLastWord(String s) {
    int count = 0;
    s = s.trim();
    for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) == ' ')
            break;
        count++;
    }
    return count;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/length-of-last-word/