# [557. Reverse Words in a String III][title]

## Problem Description

Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
```

## Solution

```java
public String reverseWords(String s) {
    StringBuilder ans = new StringBuilder();
    for (String str : s.split(" ")) {
        str = reverse(str);
        ans.append(str + " ");
    }
    return ans.toString().trim();
}
```

**private helper methods**

```java
private String reverse(String s) {
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length / 2; i++) {
        char c = chars[i];
        chars[i] = chars[chars.length - 1 - i];
        chars[chars.length - 1 - i] = c;
    }
    return new String(chars);
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/reverse-words-in-a-string-iii/