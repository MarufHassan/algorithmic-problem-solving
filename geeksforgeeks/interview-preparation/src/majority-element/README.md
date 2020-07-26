# [Majority Element][title]

## Problem Description

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    5
    3 1 3 3 2
    3
    1 2 3
Output
	3
    -1
```

## Solution

**Approach 1: Hashing**

```java
private static int findMajority(int[] a) {
    int n = a.length;
    Map<Integer, Integer> freq = new HashMap<>();
    for (int v : a) {
        freq.put(v, freq.getOrDefault(v, 0) + 1);
    }
    int lb = n / 2 + 1;
    for (int key : freq.keySet()) {
        if (freq.get(key) >= lb)
            return key;
    }
    return -1;
}
```

**Approach 2: Divide and Conquer**

```java
public static int findMajority(int[] a) {
    return find(a, 0, a.length - 1);
}
private static int find(int[] a, int low, int high) {
    if (high <= low)
        return a[low];
    int mid = low + (high - low) / 2;
    
    int lElement = find(a, low, mid);
    int rElement = find(a, mid + 1, high);
    
    if (lElement == rElement)
        return lElement;
        
    int lCount = frequency(a, lElement, low, high);
    int rCount = frequency(a, rElement, low, high);
    
    if (lCount >= (high - low + 1) / 2 + 1)
        return lElement;
    if (rCount >= (high - low + 1) / 2 + 1)
        return rElement;
    return -1;
}
```

**Helper Method**

```java
private static int frequency(int[] a, int element, int low, int high) {
    int count = 0;
    for (int i = low; i <= high; i++) {
        if (a[i] == element)
            count++;
    }
    return count;
}
```


## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/majority-element/0/