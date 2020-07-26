# [Max sum path in two arrays][title]

## Problem Description

Given two sorted arrays A and B. The task is to complete the function max_path_sum that takes 4 argument, the first two arguments represent the 2 arrays A[] and B[] and the last two arguments l1, l2 denote the size of array A and B respectively. The function returns the sum of the maximum sum path to reach from beginning of any array to end of any of the two arrays .

Note: You can switch from one array to another array only at common elements.

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    5 4
    2 3 7 10 12
    1 5 7 8 
    3 3
    1 2 4
    1 2 7
Output
	35
    10
```

## Solution

```java
int maxPathSum(int[] arr1, int[] arr2) {
    int sum1 = 0, sum2 = 0, maxsum = 0;
    int i = 0, j = 0, len1 = arr1.length, len2 = arr2.length;
    
    while (i < len1 && j < len2) {
        if      (arr1[i] < arr2[j]) { sum1 += arr1[i]; i++; }
        else if (arr1[i] > arr2[j]) { sum2 += arr2[j]; j++; }
        else {
            maxsum += Math.max(sum1, sum2);
            maxsum += arr1[i];
            sum1 = 0; sum2 = 0;
            i++; j++;
        }
    }
    while (i < len1)
        sum1 += arr1[i++];
    while (j < len2)
        sum2 += arr2[j++];
    maxsum += Math.max(sum1, sum2);
    
    return maxsum;
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/max-sum-path-in-two-arrays/1/