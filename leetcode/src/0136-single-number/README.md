# [136. Single Number][title]

## Problem Description

Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Detailed description can be found [here][title].

**Example 1:**

```
Input: [2,2,1]
Output: 1
```

**Example 2:**

```
Input: [4,1,2,1,2]
Output: 4
```

## Solution

**Approach 1: Hash Table**

```java
public int singleNumber(int[] nums) {
    Map<Integer, Integer> count = new HashMap<>();
    
    for (int n : nums) {
        count.put(n, count.getOrDefault(n, 0) + 1);
    }
    
    for (int k : count.keySet()) {
        if (count.get(k) == 1)
            return k;
    }
    return -1;
}
```

**Approach 2: Bit Manipulation**

```java
public int singleNumber(int[] nums) {
    int a = 0;
    for (int n : nums) {
        a ^= n;
    }
    return a;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/single-number/