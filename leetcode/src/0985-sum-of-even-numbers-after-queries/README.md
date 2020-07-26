# [985. Sum of Even Numbers After Queries][title]

## Problem Description

We have an array A of integers, and an array queries of queries.

For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then, the answer to the i-th query is the sum of the even values of A.

(Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)

Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.

Detail instruction can be found [here][title].

**Example:**

```
Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
Output: [8,6,2,4]

Explanation: 
At the beginning, the array is [1,2,3,4].
After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
```

## Solution

**Approach 1: Brute Force**

```java
public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
    int n = queries.length;
    int[] ans = new int[n];
    
    for (int i = 0; i < n; i++) {
        int val = queries[i][0];
        int index = queries[i][1];
        
        A[index] += val;
        ans[i] = evensum(A);
    }
    return ans;
}
```

**private helper methods**

```java
private int evensum(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] % 2 == 0)
            sum += arr[i];
    }
    return sum;
}
```

**Approach 2: O(n) time and O(1) space complexity**

```java
public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
    int n = queries.length;
    int[] ans = new int[n];
    int evensum = 0;
    for (int i = 0; i < A.length; i++) {
        if (A[i] % 2 == 0)
            evensum += A[i];
    }
    
    for (int i = 0; i < n; i++) {
        int index = queries[i][1];
        int value = queries[i][0];
        if ((A[index] + value) % 2 == 0) {
            evensum += value;
            if (A[index] % 2 != 0)
                evensum += A[index];
        } else {
            if (A[index] % 2 == 0)
                evensum -= A[index];
        }
        A[index] += value;
        ans[i] = evensum;
    }
    return ans;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/sum-of-even-numbers-after-queries/