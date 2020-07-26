# [Strings: Making Anagrams][title]

## Problem Description

Given two strings, _a_ and _b_, that may or may not be of the same length, determine the minimum number of character deletions required to make  and  anagrams. Any characters can be deleted from either of the strings. Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        cde
        abc
    Output:
        4
```

## Solution

**Approach: Frequency Counting**

```java
static int makeAnagram(String a, String b) {
    int[] frequency = new int[127];

    for (int i = 0; i < a.length(); i++) frequency[a.charAt(i)]++;
    for (int i = 0; i < b.length(); i++) frequency[b.charAt(i)]--;

    int remove = 0;
    for (int i = 0; i < 127; i++) {
        remove += Math.abs(frequency[i]);
    }

    return remove;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/ctci-making-anagrams