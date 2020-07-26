# [1167. Minimum Cost to Connect Sticks][title]

## Problem Description

You have some sticks with positive integer lengths.

You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.  You perform this action until there is one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.

**Example 1:**

```
Input: sticks = [2,4,3]
Output: 14
```

**Example 2:**

```
Input: sticks = [1,8,3,5]
Output: 30
```

## Solution

```java
public int connectSticks(int[] sticks) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    for (int stick : sticks) {
        pq.offer(stick);
    }
    
    int cost=  0;
    while (pq.size() > 1) {
        int pop = pq.remove() + pq.remove();
        cost += pop;
        pq.offer(pop);
    }
    return cost;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/minimum-cost-to-connect-sticks/