# [696. Count Binary Substrings][title]

## Problem Description

Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

Notice that some of these substrings repeat and are counted the number of times they occur.

Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
```

**Example 2:**

```
Input: "10101"
Output: 4

Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
```

## Solution

**Approach 1: Group By Character**

```java
public int countBinarySubstrings(String s) {
    List<Integer> groups = new ArrayList<>();
    
    int count = 1;
    for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) != s.charAt(i - 1)) {
            groups.add(count);
            count = 1;
        } else
            count++;
    }
    groups.add(count);
    
    count = 0;
    for (int i = 1; i < groups.size(); i++) {
        count += Math.min(groups.get(i), groups.get(i - 1));
    }
    
    return count;
}
```

**Approach 2: Linear Scan**

```java
public int countBinarySubstrings(String s) {
    int ans = 0, prev = 0, curr = 1;
    
    for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) != s.charAt(i - 1)) {
            ans += Math.min(prev, curr);
            prev = curr;
            curr = 1;
        } else
            curr++;
    }
    
    return ans + Math.min(prev, curr);
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/count-binary-substrings