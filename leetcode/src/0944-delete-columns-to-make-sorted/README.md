# [944. Delete Columns to Make Sorted][title]

## Problem Description
Suppose we chose a set of deletion indices `D` such that after deletions, each remaining column in A is in non-decreasing sorted order.

Return the minimum possible value of `D.length`. Detailed description can be found [here][title]

**Example 1:**

```
Input: ["cba","daf","ghi"]
Output: 1
Explanation: 
After choosing D = {1}, each column ["c","d","g"] and ["a","f","i"] are in non-decreasing sorted order.
If we chose D = {}, then a column ["b","a","h"] would not be in non-decreasing sorted order.
```

**Example 2:**

```
Input: ["a","b"]
Output: 0
Explanation: D = {}
```

**Example 3:**

```
Input: ["zyx","wvu","tsr"]
Output: 3
Explanation: D = {0, 1, 2}
```

## Solution


```java
public int minDeletionSize(String[] A) {
    int slen = A[0].length();
    int count = 0;
    for (int i = 0; i < slen; i++) {
        for (int j = 0; j < A.length - 1; j++) {
            if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                count++;
                break;
            }
        }
    }
    return count;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/delete-columns-to-make-sorted/