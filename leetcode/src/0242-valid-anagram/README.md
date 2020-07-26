# [49. Group Anagrams][title]

## Problem Description

Given an array of strings, group anagrams together.

**Example 1:**

```
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```

## Solution


```java
public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> freq = new HashMap<>();
    
    for (String s : strs) {
        String key = codes(s);
        freq.putIfAbsent(key, new ArrayList<>());
        freq.get(key).add(s);
    }
    
    return new ArrayList<>(freq.values());
}
```

**private helper  method**

```java
private String codes(String s) {
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
        count[c - 'a']++;
    }
    return Arrays.toString(count);
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/group-anagrams/