# [Maximum Sub Array][title]

## Problem Description

Find out the maximum sub-array of non negative numbers from an array.
The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    3
    1 2 3
    2
    -1  2
Output
	1 2 3
    2
```

## Solution

```java
private static int[] maximumSubArray(int[] arr) {
    int n = arr.length;
    int start = 0, i = 0, j = 0;
    int maxSum = 0, maxLength = 0, sum = 0;
    
    while (i < n) {
        while (i < n && arr[i] < 0)
            i++;
            
        j = i;
        sum = 0;
        while (j < n && arr[j] >= 0) 
            sum += arr[j++];
        
        if (sum > maxSum) {
            maxSum = sum;
            start = i;
            maxLength = j - i;
        } else if (sum == maxSum && j - i > maxLength) {
            start = i;
            maxLength = j - i;
        }
        i = j;
    }
    
    int[] ans = new int[maxLength];
    for (i = 0; i < maxLength; i++) {
        ans[i] = arr[i + start];
    }
    return ans;
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/maximum-sub-array/0/