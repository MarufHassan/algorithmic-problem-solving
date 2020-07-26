# [Jesse and Cookies][title]

## Problem Description

YYou are given Jesse's cookies. Print the number of operations required to give the cookies a sweetness . Print  if this isn't possible.

Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        6 7
        1 2 3 9 10 12
    Output:
        2
```

## Solution

```java
static int cookies(int k, int[] A) {
    int n = A.length;
    PriorityQueue<Integer> q = new PriorityQueue<Integer>();
    for (int i = 0; i < n; i++) {
        q.add(A[i]);
    }
    int count = 0;
    while (q.size() > 0) {
        if (q.peek() >= k)
            return count;
        int c1 = q.poll();
        if (q.size() == 0)
            return -1;
        int c2 = q.poll();
        q.add(c1 + 2 * c2);
        count++;
    }
    return -1;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/jesse-and-cookies/problem