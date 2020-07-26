# [76. Minimum Window Substring][title]

## Problem Description

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

**Example 1:**

```
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
```

## Solution

**Approach 1: Brute Force (TLE)**

```java
private boolean isvalid(int[] sfreq, int[] tfreq) {
    for (int i = 0; i < sfreq.length; i++) {
        if (sfreq[i] < tfreq[i])
            return false;
    }
    return true;
}

public String minWindow(String s, String t) {
    int minLen = s.length() + 1;
    int n = s.length();
    
    int[] tfreq = new int[128];
    
    for (int i = 0; i < t.length(); i++) {
        tfreq[t.charAt(i)]++;
    }
    int ansleft = -1, ansright = -1;
    for (int i = 0; i < n; i++) {
        int[] sfreq = new int[128];
        for (int j = i; j < n; j++) {
            sfreq[s.charAt(j)]++;
            if (isvalid(sfreq, tfreq)) {
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    ansleft = i; ansright = j;
                }
            }
        }
    }
    if (ansleft == -1 && ansright == -1)
        return "";
    return s.substring(ansleft, ansright + 1);
}
```

**Approach 2: Sliding Window**

```java
private boolean isvalid(int[] sfreq, int[] tfreq) {
    for (int i = 0; i < sfreq.length; i++) {
        if (sfreq[i] < tfreq[i])
            return false;
    }
    return true;
}

public String minWindow(String s, String t) {
    if (s.length() == 0)    return "";
    
    int minLen = s.length() + 1;
    int n = s.length();
    
    int[] sfreq = new int[128];
    int[] tfreq = new int[128];
    
    for (int i = 0; i < t.length(); i++) {
        tfreq[t.charAt(i)]++;
    }
    int ansleft = 0, ansright = 0;
    int left = 0, right = 0;
    
    while (right < n) {
        if (isvalid(sfreq, tfreq)) {
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                ansleft = left; ansright = right;
            }
            sfreq[s.charAt(left)]--;
            left++;
        } else {
            sfreq[s.charAt(right)]++;
            right++;
        }
    }
    
    while (left < n) {
        if (isvalid(sfreq, tfreq)) {
            if (right - left < minLen) {
                minLen = right - left;
                ansleft = left; ansright = right;
            }
        }
        sfreq[s.charAt(left)]--;
        left++;
    }
    
    return s.substring(ansleft, ansright);
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/minimum-window-substring/