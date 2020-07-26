# [1128. Number of Equivalent Domino Pairs][title]

## Problem Description

Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

**Example 1:**

```
Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1
```

## Solution

```java
public int numEquivDominoPairs(int[][] dominoes) {
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int[] dom : dominoes) {
        if (dom[0] > dom[1]) {
            int t = dom[0];
            dom[0] = dom[1];
            dom[1] = t;
        }
    }
    
    for (int[] dom : dominoes) {
        int code = Arrays.hashCode(dom);
        map.put(code, map.getOrDefault(code, 0) + 1);
    }
    int ans = 0;
    for (int dom : map.keySet()) {
        int count = map.get(dom);
        if (count > 1) {
            ans += (count * (count - 1) / 2);
        }
    }
    return ans;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/number-of-equivalent-domino-pairs/