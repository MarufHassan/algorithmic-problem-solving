# [921. Minimum Add to Make Parentheses Valid][title]

## Problem Description

Detailed description can be found [here][title]

**Example 1:**

```
Input: "())"
Output: 1
```

**Example 2:**

```
Input: "((("
Output: 3
```

**Example 3:**

```
Input: "()"
Output: 0
```

**Example 4:**

```
Input: "()))(("
Output: 4
```

## Solution


```java
public int minAddToMakeValid(String S) {
    Stack<Character> stack = new Stack<Character>();
    for (char c : S.toCharArray()) {
        if (c == '(')
            stack.push(c);
        else {
            if (!stack.empty() && stack.peek() == '(')
                stack.pop();
            else
                stack.push(c);
        }
    }
    return stack.size();
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/