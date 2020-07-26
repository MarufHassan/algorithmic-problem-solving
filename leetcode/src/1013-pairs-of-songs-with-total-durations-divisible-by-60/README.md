# [1013. Pairs of Songs With Total Durations Divisible by 60][title]

## Problem Description

In a list of songs, the i-th song has a duration of time[i] seconds. 

Return the number of pairs of songs for which their total duration in seconds is divisible by 60.  Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.

**Example 1:**

```
Input: [30,20,150,100,40]
Output: 3

Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
```

**Example 2:**

```
Input: [60,60,60]
Output: 3

Explanation: All three pairs have a total duration of 120, which is divisible by 60.
```

## Solution

```java
public int numPairsDivisibleBy60(int[] time) {
    int[] remainders = new int[60];
    
    for (int t : time)  remainders[t % 60]++;
    
    int count = 0;
    for (int i = 1; i < 30; i++) {
        int r = 60 - i;
        count += (remainders[i] * remainders[r]);
    }
    count += (remainders[0] * (remainders[0] - 1) / 2);
    count += (remainders[30] * (remainders[30] - 1) / 2);
    
    return count;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/