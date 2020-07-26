# [14. Longest Common Prefix][title]

## Problem Description

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string `""`.

**Example 1:**

```
Input: ["flower","flow","flight"]
Output: "fl"
```

**Example 2:**

```
Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
```

**Note:**

All given inputs are in lowercase letters `a-z`.


## Solution

**Approach 1: Horizontal scanning**


```java
public String longestCommonPrefix(String[] strs) {
    if (strs.length <= 0)   return "";

    String prefix = strs[0], current;
    for (int i = 1; i < strs.length; i++) {
        current = strs[i];
        int j, len = Math.min(prefix.length(), current.length());

        for (j = 0; j < len; j++) {
            if (prefix.charAt(j) != current.charAt(j))
                break;
        }
        prefix = strs[i].substring(0, j);
    }
    return prefix;
}
```

**Approach 2: Vertical scanning**


```java
public String longestCommonPrefix(String[] strs) {
    if (strs.length <= 0) return "";
    String prefix = strs[0];
    int i, j;

    for (i = 0; i < prefix.length(); i++) {
        for (j = 1; j < strs.length; j++) {
            if (i == strs[j].length() || prefix.charAt(i) != strs[j].charAt(i))
                return prefix.substring(0, i);
        }
    }
    return prefix;
}
```

**Approach 3: Divide and conquer**


```java
public String longestCommonPrefix(String[] strs) {
    if (strs.length <= 0)   return "";
    return longestCommonPrefix(strs, 0, strs.length - 1);
}

private String longestCommonPrefix(String[] strs, int low, int high) {
    if (low >= high)        return strs[low];

    int mid = low + (high - low) / 2;

    String leftLcp  =   longestCommonPrefix(strs, low, mid);        // recursively find left half lcp of the array
    String rightLcp =   longestCommonPrefix(strs, mid + 1, high);   // recursively find right half lcp of the array

    return commonPrefix(leftLcp, rightLcp);
}

// common prefix between two string
private String commonPrefix(String left, String right) {
    int len = Math.min(left.length(), right.length());
    for (int i = 0; i < len; i++) {
        if (left.charAt(i) != right.charAt(i))
            return left.substring(0, i);
    }
    return left.substring(0, len);
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        /* see previous code */
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        
        String[] strs = new String[] {"flower", "flow", "flight"};
        assert s.longestCommonPrefix(strs).equals("fl");

        strs = new String[] {"dog", "racecar","car"};
        assert s.longestCommonPrefix(strs).equals("");

        strs = new String[] {"leetcode", "leets", ""};
        assert s.longestCommonPrefix(strs).equals("");

        strs = new String[] {"", "", ""};
        assert s.longestCommonPrefix(strs).equals("");
    }
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/longest-common-prefix