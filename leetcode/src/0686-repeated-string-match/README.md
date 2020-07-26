# [686. Repeated String Match][title]

## Problem Description

Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Detail instruction can be found [here][title].

## Solution

```java
public int repeatedStringMatch(String A, String B) {
    int m = 1;
    StringBuilder S = new StringBuilder(A);
    
    while (S.length() < B.length()) {
        S.append(A);
        m++;
    }
    if (S.indexOf(B) >= 0)
        return m;
    S.append(A);
    if (S.indexOf(B) >= 0)
        return m + 1;
    return -1;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/repeated-string-match/