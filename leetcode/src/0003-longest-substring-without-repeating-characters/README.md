# [3. Longest Substring Without Repeating Characters][title]

## Problem Description

Given a string, find the length of the longest substring without repeating characters.

**Example 1:**

```
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
```

**Example 2:**

```
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

**Example 3:**

```
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

## Solution

```java
public int lengthOfLongestSubstring(String s) {
    Set<Character> seen = new HashSet<>();
    
    int n = s.length();
    int low = 0, high = 0, maxLen = 0;
    
    while (high < n) {
        if (seen.add(s.charAt(high))) {
            high++;
            maxLen = Math.max(maxLen, high - low);
        } else {
            seen.remove(s.charAt(low));
            low++;
        }
    }
    return maxLen;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/longest-substring-without-repeating-characters/