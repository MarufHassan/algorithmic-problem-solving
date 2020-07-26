# [524. Longest Word in Dictionary through Deleting][title]

## Problem Description

Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

**Example 1:**

```
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output: 
"apple"
```

**Example 2:**

```
Input:
s = "abpcplea", d = ["a","b","c"]

Output: 
"a"
```

## Solution

```java
public String findLongestWord(String s, List<String> d) {
    String ans = "";
    
    for (String word : d) {
        if (isSubsequence(s, word)) {
            if (word.length() > ans.length()) {
                ans = word;
            } else if (word.length() == ans.length()) {
                ans = (word.compareTo(ans) < 0) ? word : ans;
            }
        }
    }
    return ans;
}
```

**private helper methods**

```java
private boolean isSubsequence(String text, String word) {
    int j = 0;
    for (int i = 0; i < text.length() && j < word.length(); i++) {
        if (text.charAt(i) == word.charAt(j))
            j++;
    }
    return j == word.length();
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/