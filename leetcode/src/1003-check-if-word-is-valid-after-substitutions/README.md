# [1003. Check If Word Is Valid After Substitutions][title]

## Problem Description

Detail instruction can be found [here][title].

**Example 1:**

```
Input: "aabcbc"
Output: true

Explanation: 
We start with the valid string "abc".
Then we can insert another "abc" between "a" and "bc", resulting in "a" + "abc" + "bc" which is "aabcbc".
```

**Example 2:**

```
Input: "abcabcababcc"
Output: true

Explanation: 
"abcabcabc" is valid after consecutive insertings of "abc".
Then we can insert "abc" before the last letter, resulting in "abcabcab" + "abc" + "c" which is "abcabcababcc".
```

**Example 3:**

```
Input: "abccba"
Output: false
```

**Example 4:**

```
Input: "cababc"
Output: false
```

## Solution

**Approach 1: Search and delete**

```java
public boolean isValid(String S) {
    StringBuilder str = new StringBuilder(S);
    while (str.length() != 0) {
        int pos = str.indexOf("abc");
        if (pos < 0)
            return false;
        str.delete(pos, pos + 3);
    }
    return true;
}
```

**Approach 2: Stack**

```java
public boolean isValid(String S) {
    if (S.length() % 3 != 0)
        return false;
    
    Stack<Character> stack = new Stack<>();
    for (char c : S.toCharArray()) {
        if (c == 'c') {
            if (!stack.isEmpty() && stack.peek() == 'b') {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() == 'a') {
                stack.pop();
            }
        } else
            stack.push(c);
    }
    return stack.isEmpty();
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/