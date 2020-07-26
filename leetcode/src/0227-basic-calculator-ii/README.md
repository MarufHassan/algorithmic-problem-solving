# [227. Basic Calculator II][title]

## Problem Description

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, \*, / operators and empty spaces . The integer division should truncate toward zero.

**Example 1:**

```
Input: "3+2*2"
Output: 7
```

**Example 2:**

```
Input: " 3/2 "
Output: 1
```

**Example 3:**

```
Input: " 3+5 / 2 "
Output: 5
```

## Solution

**Approach 1: One Stack**

```java
// TODO
```

**Approach 2: Two Stack**

[geeksforgeeks tutorial](https://www.geeksforgeeks.org/expression-evaluation/)

```java
public int calculate(String s) {
    int[] precedence = new int[128];
    precedence['+'] = 1; precedence['-'] = 1;
    precedence['*'] = 2; precedence['/'] = 2;
    
    Stack<Integer> vals = new Stack<>();
    Stack<Character> ops = new Stack<>();
    
    for (String token : split(s)) {
        char c = token.charAt(token.length() - 1);
        if (Character.isDigit(c))
            vals.push(Integer.parseInt(token));
        else {
            while (!ops.isEmpty() && precedence[ops.peek()] >= precedence[c]) {
                int num2 = vals.pop();
                int num1 = vals.pop();
                int result = operate(num1, num2, ops.pop());
                vals.push(result);
            }
            ops.push(c);
        }
    }
    while (!ops.isEmpty()) {
        int num2 = vals.pop();
        int num1 = vals.pop();
        int result = operate(num1, num2, ops.pop());
        vals.push(result);
    }
    
    return vals.pop();
}
```

**private helper  methods**

```java
private int operate(int a, int b, char op){ 
    switch(op) {
        case '+': return a + b; 
        case '-': return a - b; 
        case '*': return a * b; 
        case '/': return a / b; 
    }
    return -1;
}

private List<String> split(String s) {
    List<String> res = new ArrayList<>();
    
    int num = 0;
    for (char c : s.toCharArray()) {
        if (c == ' ')   continue;
        if (Character.isDigit(c))
            num = (10 * num + (c - '0'));
        else {
            res.add(num + "");
            res.add(c + "");
            num = 0;
        }
    }
    res.add(num + "");
    return res;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/basic-calculator-ii/