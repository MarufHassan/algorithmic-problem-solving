# [Pairs][title]

## Problem Description

You will be given an array of integers and a target value. Determine the number of pairs of array elements that have a difference equal to a target value. Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        5 2  
        1 5 3 4 2 
    Output:
        3
```

## Solution

**Approach 1: Brute Force**

```java
static int pairs(int target, int[] arr) {
    int n = arr.length;
    int count = 0;
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (Math.abs(arr[i] - arr[j]) == target)
                count++;
        }
    }
    return count;
}
```

**Approach 2: Binary Search**

```java
static int pairs(int target, int[] arr) {
    Arrays.sort(arr);
    int n = arr.length;
    int count = 0;
    for (int i = 0; i < n - 1; i++) {
        int complement = target + arr[i];
        int index = search(arr, complement, i + 1, n - 1);
        if (index > 0)
            count++;
    }
    return count;
}

static int search(int[] arr, int key, int low, int high) {
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (key < arr[mid])
            high = mid - 1;
        else if(key > arr[mid])
            low = mid + 1;
        else
            return mid;
    }
    return -1;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/pairs/