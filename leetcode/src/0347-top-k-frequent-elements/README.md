# [347. Top K Frequent Elements][title]

## Problem Description

Given a non-empty array of integers, return the k most frequent elements.

Detail instructions can be found [here][title].

**Example 1:**

```
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
```

**Example 2:**

```
Input: nums = [1], k = 1
Output: [1]
```

## Solution

**Approach 1: Sorting**

```java
public List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int v : nums) {
        freq.put(v, freq.getOrDefault(v, 0) + 1);
    }
    List<Integer> candidates = new ArrayList(freq.keySet());
    Collections.sort(candidates, new Comparator<Integer>() {
        public int compare(Integer v1, Integer v2) {
            return freq.get(v2) - freq.get(v1);
        }
    });
    return candidates.subList(0, k);
}
```

**Approach 2: Heap**

```java
public List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int v : nums) {
        freq.put(v, freq.getOrDefault(v, 0) + 1);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>(){
        public int compare(Integer v1, Integer v2) {
            int f1 = freq.get(v1);
            int f2 = freq.get(v2);
            return Integer.compare(f1, f2);
        }
    });
    for (int key : freq.keySet()) {
        pq.offer(key);
        if (pq.size() > k)
            pq.poll();
    }
    List<Integer> candidates = new ArrayList<>();
    while (pq.size() > 0) {
        candidates.add(pq.poll());
    }
    Collections.reverse(candidates);
    return candidates;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/top-k-frequent-elements/