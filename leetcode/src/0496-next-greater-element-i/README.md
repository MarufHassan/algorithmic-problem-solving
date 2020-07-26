# [496. Next Greater Element I][title]

## Problem Description

Detailed description can be found [here][title]

**Example 1:**

```
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
```

**Example 2:**

```
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
```

## Solution

**Approach 1:**

```java
public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums2.length; i++) {
        int next = -1;
        for (int j = i + 1; j < nums2.length; j++) {
            if (nums2[j] > nums2[i]) {
                next = nums2[j];
                break;
            }
        }
        map.put(nums2[i], next);
    }
    int[] result = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
        result[i] = map.getOrDefault(nums1[i], -1);
    }
    return result;
}
```

**Approach 2: Using Stack**

```java
public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length];
    Stack<Integer> stack = new Stack<Integer>();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int n : nums2) {
        while (!stack.empty() && stack.peek() < n) {
            map.put(stack.pop(), n);
        }
        stack.push(n);
    }
    int i = 0;
    for (int n : nums1)
        result[i++] = map.getOrDefault(n, -1);
    return result;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/next-greater-element-i/