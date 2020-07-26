# [1005. Maximize Sum Of Array After K Negations][title]

## Problem Description

Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.  (We may choose the same index i multiple times.)

Return the largest possible sum of the array after modifying it in this way.

**Example 1:**

```
Input: A = [4,2,3], K = 1
Output: 5
Explanation: Choose indices (1,) and A becomes [4,-2,3].
```

**Example 2:**

```
Input: A = [3,-1,0,2], K = 3
Output: 6
Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
```

**Example 3:**

```
Input: A = [2,-3,-1,5,-4], K = 2
Output: 13
Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
```

## Solution

**Approach 1: Min Heap**

```java
public int largestSumAfterKNegations(int[] A, int K) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    for (int v : A)
        pq.offer(v);
    
    for (int k = 0; k < K; k++) {
        int min = pq.remove();
        pq.offer(-min);
    }
    int sum = 0;
    while (!pq.isEmpty())
        sum += pq.remove();
    return sum;
}
```

**Approach 2: Sorting**

```java
public int largestSumAfterKNegations(int[] A, int K) {
    Arrays.sort(A);
    for (int i = 0; i < A.length; i++) {
        if (A[i] < 0 && K > 0) {
            A[i] = -A[i];
            K--;
        } else break;
    }
    Arrays.sort(A);
    if (K % 2 == 1) {
        A[0] = -A[0];
    }
    int sum = 0;
    for (int v : A) {
        System.out.print(v + " ");
        sum += v;
    }
    
    return sum;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/