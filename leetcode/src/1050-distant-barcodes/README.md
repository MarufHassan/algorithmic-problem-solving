# [1054. Distant Barcodes][title]

## Problem Description

In a warehouse, there is a row of barcodes, where the i-th barcode is barcodes[i].

Rearrange the barcodes so that no two adjacent barcodes are equal.  You may return any answer, and it is guaranteed an answer exists.

**Example 1:**

```
Input: [1,1,1,2,2,2]
Output: [2,1,2,1,2,1]
```

## Solution

```java
public int[] rearrangeBarcodes(int[] barcodes) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int b : barcodes) {
        freq.put(b, freq.getOrDefault(b, 0) + 1);
    }
    
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        public int compare(Integer i1, Integer i2) {
            return freq.get(i2) - freq.get(i1);
        }
    });
    
    for (int b : freq.keySet()) {
        pq.offer(b);
    }
    
    int[] ans = new int[barcodes.length];
    int i = 0;
    while (!pq.isEmpty()) {
        int element = pq.poll();
        for (int j = 1; j <= freq.get(element); j++) {
            ans[i] = element;
            i += 2;
            if (i >= barcodes.length) {
                i = 1;
            }
        }
    }
    
    return ans;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/distant-barcodes/