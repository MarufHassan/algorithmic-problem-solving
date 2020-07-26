# [22. Generate Parentheses][title]

## Problem Description

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Detailed description can be found [here][title].

**Example:**

```
Input: 3
Output:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```

## Solution

```java
public List<String> generateParenthesis(int n) {
    ans = new ArrayList<>();
    backtrack(n, n, "");
    return ans;
}

private void backtrack(int open, int close, String running) {
    if (open == 0 && close == 0) {
        ans.add(running);
        return;
    }
    if (open > 0) {
        backtrack(open - 1, close, running + "(");
    }
    if (open < close) {
        backtrack(open, close - 1, running + ")");
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/generate-parentheses/