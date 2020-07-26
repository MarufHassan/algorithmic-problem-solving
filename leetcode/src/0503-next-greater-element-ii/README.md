# [503. Next Greater Element II][title]

## Problem Description

Detailed description can be found [here][title]

**Example:**

```
Input: [1,2,1]
Output: [2,-1,2]

Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.
```

## Solution

**Approach 1: Brute Force**

```java
public int[] nextGreaterElements(int[] nums) {
    int[] res = new int[nums.length];
    int[] doublenums = new int[2 * nums.length];
    
    System.arraycopy(nums, 0, doublenums, 0, nums.length);
    System.arraycopy(nums, 0, doublenums, nums.length, nums.length);
    
    for (int i = 0; i < nums.length; i++) {
        res[i] = -1;
        for (int j = i + 1; j < i + nums.length; j++) {
            if (doublenums[j] > nums[i]) {
                res[i] = doublenums[j];
                break;
            }
        }
    }
    return res;
}
```

**Approach 2: Brute Force**

```java
public int[] nextGreaterElements(int[] nums) {
    int[] res = new int[nums.length];
    
    for (int i = 0; i < nums.length; i++) {
        res[i] = -1;
        for (int j = 1; j < nums.length; j++) {
            int idx = (i + j) % nums.length;
            if (nums[idx] > nums[i]) {
                res[i] = nums[idx];
                break;
            }
        }
    }
    return res;
}
```

**Approach 3: Stack**

```java
public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    Stack<Integer> s = new Stack<Integer>();
    
    for (int i = 2 * n - 1; i >= 0; i--) {
        while (!s.empty() && nums[s.peek() % n] <= nums[i % n])
            s.pop();
        res[i % n] = s.empty() ? -1 : nums[s.peek() % n];
        s.push(i);
    }
    
    return res;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/next-greater-element-ii/