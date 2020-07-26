# [500. Keyboard Row][title]

## Problem Description

Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.

**Example 1:**

```
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
```

## Solution

```java
private Map<Character, Integer> map;

public Solution() {
    map = new HashMap<>();
    
    String[] strs = {"QqWwEeRrTtYyUuIiOoPp", "AaSsDdFfGgHhJjKkLl", "ZzXxCcVvBbNnMm"};
    
    for (int i = 0; i < strs.length; i++) {
        for (char c : strs[i].toCharArray()) {
            map.put(c, i);
        }
    }
}

public String[] findWords(String[] words) {
    String[] ans = new String[words.length];
    int idx = 0;
    
    for (String word : words) {
        int index = map.get(word.charAt(0));
        for (char c : word.toCharArray()) {
            if (map.get(c) != index) {
                index = -1;
                break;
            }
        }
        if (index != -1)
            ans[idx++] = word;
    }
    
    return Arrays.copyOf(ans, idx);
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/keyboard-row/