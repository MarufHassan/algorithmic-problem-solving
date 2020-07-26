# [1180. Count Substrings with Only One Distinct Letter][title]

## Problem Description

Given a string S, return the number of substrings that have only one distinct letter.

**Example 1:**

```
Input: S = "aaaba"
Output: 8
Explanation: The substrings with one distinct letter are "aaa", "aa", "a", "b".
"aaa" occurs 1 time.
"aa" occurs 2 times.
"a" occurs 4 times.
"b" occurs 1 time.
So the answer is 1 + 2 + 4 + 1 = 8.
```

**Example 2:**

```
Input: S = "aaaaaaaaaa"
Output: 55
```

## Solution

```java
public int countLetters(String S) {
    int ans = 0;
    
    for (int i = 0; i < S.length(); ) {
        int j = i + 1;
        while (j < S.length() && S.charAt(i) == S.charAt(j)) {
            j++;
        }
        int n = j - i;
        ans += (n * (n + 1) / 2);
        i = j;
    }
    return ans;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter/