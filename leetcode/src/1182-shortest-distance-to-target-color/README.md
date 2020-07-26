# [1182. Shortest Distance to Target Color][title]

## Problem Description

You are given an array colors, in which there are three colors: 1, 2 and 3.

You are also given some queries. Each query consists of two integers i and c, return the shortest distance between the given index i and the target color c. If there is no solution return -1.

**Example 1:**

```
Input: colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
Output: [3,0,3]
Explanation: 
The nearest 3 from index 1 is at index 4 (3 steps away).
The nearest 2 from index 2 is at index 2 itself (0 steps away).
The nearest 1 from index 6 is at index 3 (3 steps away).
```

**Example 2:**

```
Input: colors = [1,2], queries = [[0,3]]
Output: [-1]
Explanation: There is no 3 in the array.
```

## Solution

```java
public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
    Map<Integer, TreeSet<Integer>> map = new HashMap<>();
    
    for (int i = 0; i < colors.length; i++) {
        map.putIfAbsent(colors[i], new TreeSet<>());
        TreeSet<Integer> indices = map.get(colors[i]);
        indices.add(i);
    }
    
    List<Integer> ans = new ArrayList<>();
    for (int[] q : queries) {
        TreeSet<Integer> indices = map.get(q[1]);
        if (indices == null) {
            ans.add(-1);
            continue;
        }
        Integer ceil = indices.ceiling(q[0]);
        Integer floor = indices.floor(q[0]);
        int min;
        if (ceil == null && floor == null) {
            min = -1;
        } else if (ceil == null) {
            min = Math.abs(q[0] - floor);
        } else if (floor == null) {
            min = Math.abs(q[0] - ceil);
        } else {
            min = Math.min(Math.abs(ceil - q[0]), Math.abs(floor - q[0]));
        }
        ans.add(min);
    }
    
    return ans;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/shortest-distance-to-target-color/