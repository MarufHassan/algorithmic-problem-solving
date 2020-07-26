# [922. Sort Array By Parity II][title]

## Problem Description

Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

You may return any answer array that satisfies this condition.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: [4,2,5,7]
Output: [4,5,2,7]

Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
```

**Example 2:**

```
Input: A = 4, B = 1
Output: "aabaa"
```

## Solution

**Approach 1: Brute Force**

```java
public int[] sortArrayByParityII(int[] A) {
    for (int i = 0; i < A.length; i++) {
        int idx;
        if (i % 2 == 0 && A[i] % 2 == 0)    continue;
        if (i % 2 == 1 && A[i] % 2 == 1)    continue;
        
        if (i % 2 == 0)     idx = find(A, i, 0);
        else                idx = find(A, i, 1);
        swap(A, i, idx);
    }
    return A;
}
```

**private helper methods**

```java
private int find(int[] A, int start, int remainder) {
    for (int i = start; i < A.length; i++) {
        if (A[i] % 2 == remainder)
            return i;
    }
    return start;
}

private void swap(int[] A, int i, int j) {
    int t = A[i];
    A[i] = A[j];
    A[j] = t;
}
```

**Approach 2: One pass, O(n) time and O(n) space complexity**

```java
public int[] sortArrayByParityII(int[] A) {
    int even = 0, odd = 1;
    int[] ans = new int[A.length];
    for (int i = 0; i < A.length; i++) {
        if (A[i] % 2 == 0) {
            ans[even] = A[i];
            even += 2;
        } else {
            ans[odd] = A[i];
            odd += 2;
        }
    }
    return ans;
}
```

**Approach 3: Two pass, O(n) time and O(1) space complexity**

```java
public int[] sortArrayByParityII(int[] A) {        
    int left = 0, right = A.length - 1;
    while (left < right) {
        if      (A[left] % 2 == 0)      left++;
        else if (A[right] % 2 != 0)     right--;
        else                            exch(A, left++, right--);
    }
    if (A[right] % 2 == 0)  right++;
    if (right % 2 == 1)     right++;
    
    for (int i = 1; right < A.length; i += 2) {
        exch(A, i, right);
        right += 2;
    }
    return A;
}
```

**Approach 4: One pass, O(n) time and O(1) space complexity**

```java
public int[] sortArrayByParityII(int[] A) {        
    int j = 1;
    for (int i = 0; i < A.length; i += 2) {
        if (A[i] % 2 == 0) continue;
        while (A[j] % 2 == 1)
            j += 2;
        exch(A, i, j);
    }
    return A;
}
```

**private helper method**

```java
private void exch(int[] A, int i, int j) {
    int t = A[i];
    A[i] = A[j];
    A[j] = t;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/sort-array-by-parity-ii/