# [Sparse Arrays][title]

## Problem Description

This question is designed to help you get a better understanding of basic heap operations. 

Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        4
        aba
        baba
        aba
        xzxb
        3
        aba
        xzxb
        ab
    Output:
        2
        1
        0
```

## Solution

```java
static int[] matchingStrings(String[] s, String[] q) {
    Map<String, Integer> freq = new HashMap<>();
    for (int i = 0; i < s.length; i++) {
        freq.put(s[i], freq.getOrDefault(s[i], 0) + 1);
    }
    int[] ans = new int[q.length];
    for (int i = 0; i < q.length; i++) {
        ans[i] = freq.getOrDefault(q[i], 0);
    }
    return ans;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/sparse-arrays/problem