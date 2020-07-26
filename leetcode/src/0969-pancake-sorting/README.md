# [969. Pancake Sorting][title]

## Problem Description

Given an array A, we can perform a pancake flip: We choose some positive integer k <= A.length, then reverse the order of the first k elements of A.  We want to perform zero or more pancake flips (doing them one after another in succession) to sort the array A.

Return the k-values corresponding to a sequence of pancake flips that sort A.  Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.

**Example 1:**

```
Input: [3,2,4,1]
Output: [4,2,4,3]

Explanation: 
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: A = [3, 2, 4, 1]
After 1st flip (k=4): A = [1, 4, 2, 3]
After 2nd flip (k=2): A = [4, 1, 2, 3]
After 3rd flip (k=4): A = [3, 2, 1, 4]
After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted. 
```

**Example 2:**

```
Input: [3,2,4,1]
Output: [4,2,4,3]

Explanation: 
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: A = [3, 2, 4, 1]
After 1st flip (k=4): A = [1, 4, 2, 3]
After 2nd flip (k=2): A = [4, 1, 2, 3]
After 3rd flip (k=4): A = [3, 2, 1, 4]
After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted. 
```

## Solution

```java
public List<Integer> pancakeSort(int[] A) {
    List<Integer> flips = new ArrayList<>();
    
    for (int i = A.length; i >= 1; i--) {
        if (A[i - 1] == i)  continue;
        int index = indexOf(A, i);
        reverse(A, 0, index);
        reverse(A, 0, i - 1);
        flips.add(index + 1);
        flips.add(i);
    }
    return flips;
}
```

**private helper methods**

```java
private int indexOf(int[] nums, int key) {
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == key)
            return i;
    }
    return -1;
}

private void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start++] = nums[end];
        nums[end--] = temp;
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/pancake-sorting/