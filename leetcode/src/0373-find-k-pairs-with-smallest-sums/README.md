# [373. Find K Pairs with Smallest Sums][title]

## Problem Description

You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Detail instructions can be found [here][title].

**Example 1:**

```
Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]] 

Explanation: The first 3 pairs are returned from the sequence: 
             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
```

**Example 2:**

```
Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [1,1],[1,1]

Explanation: The first 2 pairs are returned from the sequence: 
             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
```

**Example 3:**

```
Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [1,3],[2,3]

Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
```

## Solution

```java
public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(k, new Comparator<int[]>() {
        public int compare(int[] p1, int[] p2) {
            return (p2[0] + p2[1]) - (p1[0] + p1[1]);
        }
    });
    for (int i = 0; i < nums1.length; i++) {
        for (int j = 0; j < nums2.length; j++) {
            pq.offer(new int[] {nums1[i], nums2[j]});
            if (pq.size() > k)
                pq.poll();
        }
    }
    List<int[]> candidates = new ArrayList<>();
    while (pq.size() > 0) {
        candidates.add(pq.poll());
    }
    return candidates;
}
```


## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/