# [984. String Without AAA or BBB][title]

## Problem Description

Given two integers A and B, return any string S such that:

    S has length A + B and contains exactly A 'a' letters, and exactly B 'b' letters;
    The substring 'aaa' does not occur in S;
    The substring 'bbb' does not occur in S.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: A = 1, B = 2
Output: "abb"

Explanation: "abb", "bab" and "bba" are all correct answers.  
```

**Example 2:**

```
Input: A = 4, B = 1
Output: "aabaa"
```

## Solution


```java
public String strWithout3a3b(int A, int B) {
    char[] ans = new char[A + B];
    int i = 0;
    while (A > 0 || B > 0) {
        boolean writeA = false;
        int len = i + 1;
        if (i >= 2 && ans[i - 1] == ans[i - 2]) {
            if (ans[i - 1] == 'b')
                writeA = true;
        } else {
            if (A >= B)
                writeA = true;
        }
        if (writeA) {
            ans[i] = 'a';
            A--;
        } else {
            ans[i] = 'b';
            B--;
        }
        i++;
    }
    return new String(ans);
}
```

## Test

Compile with `javac TimeMap.java` and run with `java TimeMap`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/string-without-aaa-or-bbb/