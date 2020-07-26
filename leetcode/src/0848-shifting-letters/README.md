# [848. Shifting Letters][title]

## Problem Description

We have a string S of lowercase letters, and an integer array shifts.

Call the shift of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a'). 

For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.

Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x times.

Return the final string after all such shifts to S are applied.

**Example 1:**

```
Input: S = "abc", shifts = [3,5,9]
Output: "rpl"

Explanation: 
We start with "abc".
After shifting the first 1 letters of S by 3, we have "dbc".
After shifting the first 2 letters of S by 5, we have "igc".
After shifting the first 3 letters of S by 9, we have "rpl", the answer.
```

## Solution

```java
public String shiftingLetters(String S, int[] shifts) {
    for (int i = shifts.length - 2; i >= 0; i--) {
        shifts[i] += shifts[i + 1];
        shifts[i] %= 26;
    }
    
    char[] chars = S.toCharArray();
    for (int i = 0; i < chars.length; i++) {
        int idx = chars[i] - 'a';
        chars[i] = (char) ((idx + shifts[i]) % 26 + 'a');
    }
    return new String(chars);
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/shifting-letters/