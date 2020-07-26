# [946. Validate Stack Sequences][title]

## Problem Description
Given two sequences `pushed` and `popped` **with distinct values**, return `true` if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.

**Example 1:**

```
Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
```

**Example 2:**

```
Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.
```

## Solution


```java
public boolean validateStackSequences(int[] pushed, int[] popped) {

    Stack<Integer> stack = new Stack<Integer>();

    int i, j;

    for (i = 0, j = 0; i < pushed.length; i++) {
        stack.push(pushed[i]);
        while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
            stack.pop();
            j++;
        }
    }
    return stack.isEmpty() || j >= popped.length;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

```java
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        /* see previous code */
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        assert s.validateStackSequences(pushed, popped);

        pushed = new int[] {1, 2, 3, 4, 5};
        popped = new int[] {4, 3, 5, 1,2};
        assert !s.validateStackSequences(pushed, popped);

        pushed = new int[] {1, 2, 3, 4, 5};
        popped = new int[] {1, 2, 3, 4, 5};
        assert s.validateStackSequences(pushed, popped);

        pushed = new int[] {1, 2, 3, 4, 5};
        popped = new int[] {1, 2, 3};
        assert s.validateStackSequences(pushed, popped);

        pushed = new int[] {1, 2, 3};
        popped = new int[] {1, 2, 3, 4, 5};
        assert s.validateStackSequences(pushed, popped);
    }
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/validate-stack-sequences/