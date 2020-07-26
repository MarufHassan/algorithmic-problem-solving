# [1078. Occurrences After Bigram][title]

## Problem Description

Given words first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.

For each such occurrence, add "third" to the answer, and return the answer.

**Example 1:**

```
Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
Output: ["girl","student"]
```

**Example 2:**

```
Input: text = "we will we will rock you", first = "we", second = "will"
Output: ["we","rock"]
```

## Solution

```java
public String[] findOcurrences(String text, String first, String second) {
    String[] strs = text.split(" ");
    List<String> ans = new ArrayList<>();
    
    for (int i = 2; i < strs.length; i++) {
        if (strs[i - 2].equals(first) && strs[i - 1].equals(second))
            ans.add(strs[i]);
    }
    return ans.toArray(new String[0]);
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/occurrences-after-bigram/