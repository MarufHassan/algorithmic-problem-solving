# [784. Letter Case Permutation][title]

## Problem Description

Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Detailed description can be found [here][title].

**Example 1:**

```
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
```

## Solution

```java
public List<String> letterCasePermutation(String S) {
    permute(S.toCharArray(), 0);
    return ans;
}

private void permute(char[] str, int i) {
    if (i == str.length) {
        ans.add(String.valueOf(str)); return;
    }
    
    if (Character.isLetter(str[i])) {
        str[i] = Character.toLowerCase(str[i]);
        permute(str, i + 1);
        str[i] = Character.toUpperCase(str[i]);
    }
    permute(str, i + 1);
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/letter-case-permutation/