# [739. Daily Temperatures][title]

## Problem Description

Detailed description can be found [here][title]

**Example:**

```
Input: [73, 74, 75, 71, 69, 72, 76, 73]
Output: [1, 1, 4, 2, 1, 1, 0, 0]
```

## Solution

```java
public int[] dailyTemperatures(int[] T) {
    int n = T.length;
    int[] res = new int[n];
    Stack<Integer> stack = new Stack<Integer>();
    
    for (int i = n - 1; i >= 0; i--) {
        while (!stack.empty() && T[stack.peek()] <= T[i])
            stack.pop();
        res[i] = stack.empty() ? 0 : stack.peek() - i;
        stack.push(i);
    }
    return res;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/daily-temperatures/