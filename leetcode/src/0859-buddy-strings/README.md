# [859. Buddy Strings][title]

## Problem Description

Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: A = "ab", B = "ba"
Output: true
```

**Example 2:**

```
Input: A = "ab", B = "ab"
Output: false
```

**Example 3:**

```
Input: A = "aa", B = "aa"
Output: true
```

**Example 4:**

```
Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
```

**Example 5:**

```
Input: A = "", B = "aa"
Output: false
```

## Solution

```java
public boolean buddyStrings(String A, String B) {
    if (A.length() != B.length())
        return false;
    
    if (A.equals(B)) {
        int[] freq = new int[26];
        for (char c : A.toCharArray()) {
            freq[c - 'a']++;
            if (freq[c - 'a'] > 1)
                return true;
        }
        return false;
    }
    int first = -1, second = -1;
    for (int i = 0; i < A.length(); i++) {
        if (A.charAt(i) != B.charAt(i)) {
            if (first == -1)
                first = i;
            else if (second == -1)
                second = i;
            else
                return false;
        }
    }
    return (second != -1 && A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first));
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/buddy-strings/