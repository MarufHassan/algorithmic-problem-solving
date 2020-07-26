# [387. First Unique Character in a String][title]

## Problem Description

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Detail instruction can be found [here][title].

**Example 1:**

```
s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
```

## Solution

```java
public int firstUniqChar(String s) {
    int[] freq = new int[26];
    for (char c : s.toCharArray()) {
        freq[c - 'a']++;
    }
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (freq[c - 'a'] == 1)
            return i;
    }
    return -1;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/first-unique-character-in-a-string/