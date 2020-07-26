# [1151. Minimum Swaps to Group All 1's Together][title]

## Problem Description

Given a binary array data, return the minimum number of swaps required to group all 1’s present in the array together in any place in the array.

**Example 1:**

```
Input: [1,0,1,0,1]
Output: 1

Explanation: 
There are 3 ways to group all 1's together:
[1,1,1,0,0] using 1 swap.
[0,1,1,1,0] using 2 swaps.
[0,0,1,1,1] using 1 swap.
The minimum is 1.
```

**Example 2:**

```
Input: [0,0,0,1,0]
Output: 0

Explanation: 
Since there is only one 1 in the array, no swaps needed.
```

**Example 3:**

```
Input: [1,0,1,0,1,0,0,1,1,0,1]
Output: 3

Explanation: 
One possible solution that uses 3 swaps is [0,0,0,0,0,1,1,1,1,1,1].
```

## Solution

```java
public int minSwaps(int[] data) {
    int ones = 0;
    for (int n : data) {
        if (n == 1) ones++;
    }
    if (ones == 0)  return 0;
    
    int[] precompute = new int[data.length];
    if (data[0] == 1)
        precompute[0] = 1;
    for (int i = 1; i < data.length; i++) {
        if (data[i] == 1) {
            precompute[i] = precompute[i - 1] + 1;
        } else {
            precompute[i] = precompute[i - 1];
        }
    }
    int max = -1, numOfOnes;
    for (int i = ones - 1; i < data.length; i++) {
        if (i == (ones - 1)) {
            numOfOnes = precompute[i];
        } else {
            numOfOnes = precompute[i] - precompute[i - ones];
        }
        max = Math.max(max, numOfOnes);
    }
    return ones - max;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together