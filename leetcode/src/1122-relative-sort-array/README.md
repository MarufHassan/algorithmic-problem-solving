# [1122. Relative Sort Array][title]

## Problem Description

Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.

**Example 1:**

```
Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
```

## Solution

```java
private static int INF = Integer.MAX_VALUE;

public int[] relativeSortArray(int[] arr1, int[] arr2) {
    Map<Integer, Integer> index = new HashMap<>();
    
    for (int i = 0; i < arr2.length; i++) {
        index.put(arr2[i], i);
    }
    
    Integer[] res = new Integer[arr1.length];
    for (int i = 0; i < res.length; i++) {
        res[i] = arr1[i];
    }
    
    Arrays.sort(res, new Comparator<Integer>() {
        public int compare(Integer n1, Integer n2) {
            int diff = index.getOrDefault(n1, INF) - index.getOrDefault(n2, INF);
            return diff == 0 ? n1 - n2 : diff;
        }
    });
    
    for (int i = 0; i < arr1.length; i++) {
        arr1[i] = res[i];
    }
    return arr1;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/relative-sort-array/