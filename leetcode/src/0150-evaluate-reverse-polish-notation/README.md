# [150. Evaluate Reverse Polish Notation][title]

## Problem Description

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, \*, /. Each operand may be an integer or another expression.

**Example 1:**

```
Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
```

**Example 2:**

```
Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
```

**Example 3:**

```
Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
```

## Solution

```java
public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    
    for (String token : tokens) {
        char c = token.charAt(token.length() - 1);
        
        if (Character.isDigit(c)) {
            int num = Integer.parseInt(token);
            stack.push(num);
        } else {
            int num1 = stack.pop();
            int num2 = stack.pop();
            if (c == '+')       stack.push(num2 + num1);
            else if (c == '-')  stack.push(num2 - num1);
            else if (c == '*')  stack.push(num2 * num1);
            else                stack.push(num2 / num1);
        }
    }
    return stack.peek();
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/evaluate-reverse-polish-notation/