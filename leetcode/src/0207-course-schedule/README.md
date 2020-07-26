# [207. Course Schedule][title]

## Problem Description

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Detailed description can be found [here][title].

**Example 1:**

```
Input: 2, [[1,0]] 
Output: true

Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
```

**Example 2:**

```
Input: 2, [[1,0],[0,1]]
Output: false

Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
```

## Solution

```java
public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[numCourses];
    
    for (int i = 0; i < adj.length; i++) {
        adj[i] = new ArrayList<Integer>();
    }
    for (int[] pre : prerequisites) {
        adj[pre[1]].add(pre[0]);
    }
    
    marked = new boolean[numCourses];
    onStack = new boolean[numCourses];
    
    for (int v = 0; v < numCourses; v++) {
        if (!marked[v] && !hasCycle)
            dfs(adj, v);
    }
    
    return !hasCycle;
}

private void dfs(List<Integer>[] adj, int v) {
    marked[v] = true;
    onStack[v] = true;
    for (int w : adj[v]) {
        if (!marked[w])
            dfs(adj, w);
        else if (onStack[w])
            hasCycle = true;
    }
    onStack[v] = false;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/course-schedule/