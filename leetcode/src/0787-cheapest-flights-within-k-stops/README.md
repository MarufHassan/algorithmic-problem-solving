# [787. Cheapest Flights Within K Stops][title]

## Problem Description

There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

**Example 1:**

```
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
```

**Example 2:**

```
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
```

## Solution

```java
public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    int[] cost = new int[n], curr = null;
    Arrays.fill(cost, INF);
    cost[src] = 0;
    int ans = cost[dst];
    
    for (int i = K; i >= 0; i--) {
        curr = Arrays.copyOf(cost, cost.length);
        
        for (int[] flight : flights) {
            int u = flight[0], v = flight[1], weight = flight[2];
            // edge relaxation
            if (cost[u] != INF && cost[u] + weight < curr[v]) {
                curr[v] = cost[u] + weight;
            }
        }
        cost = curr;
    }
    
    return (cost[dst] == INF) ? -1 : cost[dst];
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/cheapest-flights-within-k-stops/