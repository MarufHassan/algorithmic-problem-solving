# [844. Backspace String Compare][title]

## Problem Description

Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character. Detailed description can be found [here][title]

**Example 1:**

```
Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
```

**Example 2:**

```
Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
```

**Example 3:**

```
Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
```

## Solution


```java
public boolean backspaceCompare(String S, String T) {
    return build(S).equals(build(T));
}

private String build(String s) {
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c != '#')
            stack.push(c);
        else if (!stack.empty())
            stack.pop();
    }
    return String.valueOf(stack);
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/backspace-string-compare/