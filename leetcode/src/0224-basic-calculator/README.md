# [224. Basic Calculator][title]

## Problem Description

Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

**Example 1:**

```
Input: "1 + 1"
Output: 2
```

**Example 2:**

```
Input: " 2-1 + 2 "
Output: 3
```

**Example 3:**

```
Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
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
    System.out.println(Arrays.toString(split(s)));
    
    for (String token : split(s)) {
        char c = token.charAt(token.length() - 1);
        if (Character.isDigit(c))
            vals.push(Integer.parseInt(token));
        else if (c == '(')
            ops.push(c);
        else if (c ==  ')') {
            while (!ops.isEmpty() && ops.peek() != '(') {
                int num2 = vals.pop();
                int num1 = vals.pop();
                int result = operate(num1, num2, ops.pop());
                vals.push(result);
            }
            ops.pop();
        } else {
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

// not efficient but easy to understand
private String[] split(String s) {        
    String[] chars = {"+", "-", "*", "/", "(", ")"};

    for (String character : chars) {
        s = s.replace(character, " " + character + " ");
    }
    s = s.trim();
    return s.split(" +");
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/basic-calculator/