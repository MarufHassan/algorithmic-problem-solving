# [1023. Camelcase Matching][title]

## Problem Description

A query word matches a given pattern if we can insert lowercase letters to the pattern word so that it equals the query. (We may insert each character at any position, and may insert 0 characters.)

Given a list of queries, and a pattern, return an answer list of booleans, where answer[i] is true if and only if queries[i] matches the pattern.

Detailed description can be found [here][title].

**Example 1:**

```
Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
Output: [true,false,true,true,false]

Explanation: 
"FooBar" can be generated like this "F" + "oo" + "B" + "ar".
"FootBall" can be generated like this "F" + "oot" + "B" + "all".
"FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
```

**Example 2:**

```
Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
Output: [true,false,true,false,false]

Explanation: 
"FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
"FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".
```

**Example 3:**

```
Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
Output: [false,true,false,false,false]

Explanation: 
"FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".
```

## Solution

```java
private boolean matches(char[] query, char[] pat) {
    int ptr1 = 0, ptr2 = 0;
    for (; ptr1 < query.length; ptr1++) {
        if (ptr2 < pat.length && query[ptr1] == pat[ptr2]) 
            ptr2++;
        else if (Character.isUpperCase(query[ptr1]))
            return false;
    }
    return ptr2 == pat.length;
}

public List<Boolean> camelMatch(String[] queries, String pattern) {
    List<Boolean> ans = new ArrayList<>();
    char[] pat = pattern.toCharArray();
    for (String word : queries) {
        ans.add(matches(word.toCharArray(), pat));
    }
    
    return ans;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/camelcase-matching/