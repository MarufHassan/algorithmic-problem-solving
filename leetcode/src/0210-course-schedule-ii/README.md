# [210. Course Schedule II][title]

## Problem Description

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Detailed description can be found [here][title].

**Example 1:**

```
Input: 2, [[1,0]] 
Output: [0,1]

Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
```

**Example 2:**

```
Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]

Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
```

## Solution

```java
public int[] findOrder(int numCourses, int[][] prerequisites) {
   List<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[numCourses];
    
    for (int i = 0; i < adj.length; i++) {
        adj[i] = new ArrayList<Integer>();
    }
    for (int[] pre : prerequisites) {
        adj[pre[1]].add(pre[0]);
    }
    
    order = new int[numCourses];
    marked = new boolean[numCourses];
    onStack = new boolean[numCourses];
    
    for (int v = 0; v < numCourses; v++) {
        if (!marked[v] && !hasCycle)
            dfs(adj, v);
    }
    
    return hasCycle ? new int[0] : reverse(order);
}

private void dfs(List<Integer>[] adj, int v) {
    marked[v] = true;
    onStack[v] = true;
    for (int w : adj[v]) {
        if (!marked[w] && !hasCycle)
            dfs(adj, w);
        else if (onStack[w])
            hasCycle = true;
    }
    order[idx++] = v;
    onStack[v] = false;
}
```

**private helper methods**

```java

private int[] reverse(int[] order) {
    int i = 0, j = order.length - 1;
    while (i < j) {
        int t = order[i];
        order[i++] = order[j];
        order[j--] = t;
    }
    return order;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/course-schedule-ii/