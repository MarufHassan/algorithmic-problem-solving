# [17. Letter Combinations of a Phone Number][title]

## Problem Description

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Detailed description can be found [here][title].

**Example:**

```
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
```

## Solution

```java
public List<String> letterCombinations(String digits) {
    ans = new ArrayList<>();
    if (digits.length() == 0)   return ans;
    generate(digits, 0, "");
    return ans;
}

private void generate(String digits, int offset, String prefix) {
    if (offset >= digits.length()) {
        ans.add(prefix);
        return;
    }
    
    String letters = map[digits.charAt(offset) - '0'];
    for (int j = 0; j < letters.length(); j++) {
        generate(digits, offset + 1, prefix + letters.charAt(j));
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/letter-combinations-of-a-phone-number/