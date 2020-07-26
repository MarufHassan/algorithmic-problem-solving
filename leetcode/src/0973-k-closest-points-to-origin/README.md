# [973. K Closest Points to Origin][title]

## Problem Description

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.) Detailed description can be found [here][title]

**Example 1:**

```
Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]

Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
```

**Example 2:**

```
Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]

(The answer [[-2,4],[3,3]] would also be accepted.)
```

## Solution

```java
public int[][] kClosest(int[][] points, int K) {
    int n = points.length;
    Point[] arr = new Point[n];
    for (int i = 0; i < n; i++) {
        int x = points[i][0];
        int y = points[i][1];
        arr[i] = new Point(x, y, (x * x + y * y));
    }
    Arrays.sort(arr, new Comparator<Point>() {
        public int compare(Point a, Point b) {
            if (a.dist < b.dist)  return -1;
            if (a.dist > b.dist)  return +1;
            return 0;
        }
    });
    
    int[][] res = new int[K][2];
    for (int i = 0; i < K; i++) {
        res[i][0] = arr[i].x;
        res[i][1] = arr[i].y;
    }
    return res;
}
```

**Helper Class**

```java
private class Point {
    int x, y, dist;
    Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/k-closest-points-to-origin/