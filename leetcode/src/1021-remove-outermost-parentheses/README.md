# [1021. Remove Outermost Parentheses][title]

## Problem Description

A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.

A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.

Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.

Detailed description can be found [here][title].

**Example 1:**

```
Input: "(()())(())"
Output: "()()()"

Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
```

**Example 2:**

```
Input: "(()())(())(()(()))"
Output: "()()()()(())"

Explanation: 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
```

**Example 3:**

```
Input: "()()"
Output: ""

Explanation: 
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".
```

## Solution

**Approach 1: Stack**

```java
public String removeOuterParentheses(String S) {
    Stack<Character> stack = new Stack<>();
    StringBuilder ans = new StringBuilder();
    
    for (int i = 0, j = 0; i < S.length(); i++) {
        if (S.charAt(i) == ')') {
            stack.pop();
            if (stack.isEmpty()) {
                ans.append(S.substring(j + 1, i));
                j = i + 1;
            }
        } else {
            stack.push('(');
        }
    }
    
    return ans.toString();
}
```

**Approach 2:**

```java
public String removeOuterParentheses(String S) {
    StringBuilder ans = new StringBuilder();
    int opened = 0;
    for (int i = 0; i < S.length(); i++) {
        char c = S.charAt(i);
        if (c == '(' && opened++ > 0) {
            ans.append('(');
        }
        if (c == ')' && opened-- > 1) {
            ans.append(')');
        }
    }
    
    return ans.toString();
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/remove-outermost-parentheses/