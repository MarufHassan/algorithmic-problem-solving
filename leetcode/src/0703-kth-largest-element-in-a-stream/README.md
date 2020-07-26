# [703. Kth Largest Element in a Stream][title]

## Problem Description

Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

Detail instructions can be found [here][title].

**Example:**

```
int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
```

## Solution

```java
class KthLargest {
PriorityQueue<Integer> pq;
int k;

public KthLargest(int k, int[] nums) {
    pq = new PriorityQueue<Integer>();
    this.k = k;
    for (int i = 0; i < nums.length; i++)
        add(nums[i]);
}

public int add(int val) {
    pq.add(val);
    if (pq.size() > k)
        pq.poll();
    return pq.peek();
}
}
```

## Test

Compile with `javac KthLargest.java` and run with `java KthLargest`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/kth-largest-element-in-a-stream/