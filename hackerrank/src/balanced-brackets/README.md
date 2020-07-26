# [Balanced Brackets][title]

## Problem Description

Given _n_ strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return `YES`. Otherwise, return `NO`.

Detail description can be found [here][title].

**Example:**

```
    Input: 
        3
        {[()]}
        {[(])}
        {{[[(())]]}}
    Output:
        YES
        NO
        YES
```


## Solution


```java
static String isBalanced(String s) {
    Stack<Character> stack = new Stack<Character>();
    char[] table = new char[128];
    table[')'] = '('; table['}'] = '{'; table[']'] = '[';

    for (char c: s.toCharArray()) {
        if (!stack.isEmpty() && table[c] == stack.peek())
            stack.pop();
        else 
            stack.push(c);
    }
    return stack.isEmpty() ? "YES" : "NO";
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/balanced-brackets