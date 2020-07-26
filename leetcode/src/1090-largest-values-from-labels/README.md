# [1090. Largest Values From Labels][title]

## Problem Description

We have a set of items: the i-th item has value values[i] and label labels[i].

Then, we choose a subset S of these items, such that:

|S| <= num_wanted
For every label L, the number of items in S with label L is <= use_limit.
Return the largest possible sum of the subset S.

**Example 1:**

```
Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
Output: 9

Explanation: The subset chosen is the first, third, and fifth item.
```

**Example 2:**

```
Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
Output: 12

Explanation: The subset chosen is the first, second, and third item.
```

**Example 3:**

```
Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
Output: 16

Explanation: The subset chosen is the first and fourth item.
```

**Example 4:**

```
Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
Output: 24

Explanation: The subset chosen is the first, second, and fourth item.
```

## Solution

```java
public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
    Map<Integer, Integer> freq = new HashMap<>();
    
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
            return b[0] - a[0];
        }
    });
    
    for (int i = 0; i < values.length; i++) {
        freq.putIfAbsent(labels[i], 0);
        pq.offer(new int[] {values[i], labels[i]});
    }
    
    int sum = 0, i = 0;
    while (i < num_wanted && !pq.isEmpty()) {
        int[] pair = pq.remove();
        if (freq.get(pair[1]) < use_limit) {
            sum += pair[0];
            freq.put(pair[1], freq.get(pair[1]) + 1);
            i++;
        }
    }
    return sum;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/largest-values-from-labels/