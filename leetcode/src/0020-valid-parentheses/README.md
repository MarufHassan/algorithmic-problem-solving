# [20. Valid Parentheses][title]

## Problem Description
Given a string containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

**Example 1:**

```
Input: "()"
Output: true
```

**Example 2:**

```
Input: "()[]{}"
Output: true
```

**Example 3:**

```
Input: "(]"
Output: false
```

**Example 4:**

```
Input: "([)]"
Output: false
```

**Example 5:**

```
Input: "{[]}"
Output: true
```

## Solution


```java
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();
    char[] table = new char[128];
    table[')'] = '('; table['}'] = '{'; table[']'] = '[';

    for (char c: s.toCharArray()) {
        if (!stack.isEmpty() && table[c] == stack.peek())
            stack.pop();
        else 
            stack.push(c);
    }
    return stack.isEmpty();
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.




**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/valid-parentheses/