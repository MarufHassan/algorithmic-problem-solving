# [QHEAP1][title]

## Problem Description

This question is designed to help you get a better understanding of basic heap operations. 

Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        5  
        1 4  
        1 9  
        3  
        2 4  
        3  
    Output:
        4  
        9 
```

## Solution

```java
public void solve() {
    Scanner in = new Scanner(System.in);
    PriorityQueueInteger pq = new PriorityQueue();
    int q = in.nextInt();
    while (q--  0) {
        int type = in.nextInt();
        if (type == 1) {
            int n = in.nextInt();
            pq.offer(n);
        } else if (type == 2) {
            int n = in.nextInt();
            pq.remove(n);
        } else {
            System.out.println(pq.peek());
        }
    }
    in.close();
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/qheap1/problem