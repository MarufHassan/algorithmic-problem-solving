# [875. Koko Eating Bananas][title]

## Problem Description

Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  The guards have gone and will come back in H hours.

Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.

Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.

Return the minimum integer K such that she can eat all the bananas within H hours.


**Example 1:**

```
Input: piles = [3,6,7,11], H = 8
Output: 4
```

**Example 2:**

```
Input: piles = [30,11,23,4,20], H = 5
Output: 30
```

**Example 3:**

```
Input: piles = [30,11,23,4,20], H = 6
Output: 23
```

## Solution

```java
public int minEatingSpeed(int[] piles, int H) {
    int lo = 1, hi = 0;
    
    for (int b : piles) {
        hi = Math.max(b, hi);
    }
    
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        int time = time(piles, mid);
        
        if (time <= H)  hi = mid;
        else            lo = mid + 1;
    }
    return lo;
}
```

**private helper methods**

```java
private int time(int[] piles, int capacity) {
    int t = 0;
    for (int b : piles) {
        t += (b - 1) / capacity + 1;
    }
    return t;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/koko-eating-bananas/