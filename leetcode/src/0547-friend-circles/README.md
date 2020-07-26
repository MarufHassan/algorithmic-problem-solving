# [547. Friend Circles][title]

## Problem Description

There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

Detail instructions can be found [here][title].

**Example 1:**

```
Input: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2

Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
The 2nd student himself is in a friend circle. So return 2.
```

**Example 2:**

```
Input: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1

Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
```

## Solution

```java
public int findCircleNum(int[][] M) {
    int n = M.length;
    UF uf = new UF(n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (M[i][j] != 0) {
                uf.union(i, j);
            }
        }
    }
    return uf.components();
}
```

**helper class**

```java
class UF {
    int[] id, rank;
    int components;
    
    public UF(int n) {
        id = new int[n];
        rank = new int[n];
        components = n;
        
        for (int i = 0; i < n; i++) 
            id[i] = i;
    }
    
    private int root(int i) {
        while (i != id[i]) {
            // path compression heuristics
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
    
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j)
            return;
        // rank heuristics
        if (rank[i] < rank[j])
            id[i] = j;
        else {
            id[j] = i;
            if (rank[i] == rank[j])
                rank[j] += 1;
        }
        components--;
    }
    
    public int components() {
        return components;
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/friend-circles/