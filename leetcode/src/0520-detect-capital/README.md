# [520. Detect Capital][title]

## Problem Description

Detail instruction can be found [here][title].

**Example 1:**

```
Input: "USA"
Output: True
```

**Example 2:**

```
Input: "FlaG"
Output: False
```

## Solution

```java
public boolean detectCapitalUse(String word) {
    int upper = 0;
    
    for (char c : word.toCharArray()) {
        if (Character.isUpperCase(c))
            upper++;
    }
    
    if (upper == 1) {
        return Character.isUpperCase(word.charAt(0));
    }
    return upper == 0 || upper == word.length();
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/detect-capital/