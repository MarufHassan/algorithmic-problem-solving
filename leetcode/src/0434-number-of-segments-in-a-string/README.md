# [434. Number of Segments in a String][title]

## Problem Description

Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: "Hello, my name is John"
Output: 5
```

## Solution

**Approach 1:**

```java
public int countSegments(String s) {
    s = s.trim();
    if (s.length() == 0) return 0;
    return s.split(" +").length;
}
```

**Approach 2:**

```java
class Solution {
    public int countSegments(String s) {
        int i = 0, count = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ')
                i++;
            if (i == s.length()) break;
            while (i < s.length() && s.charAt(i) != ' ')
                i++;
            count++;
        }
        return count;
    }
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/number-of-segments-in-a-string