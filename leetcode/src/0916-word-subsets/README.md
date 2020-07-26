# [916. Word Subsets][title]

## Problem Description

We are given two arrays A and B of words.  Each word is a string of lowercase letters.

Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".

Now say a word a from A is universal if for every b in B, b is a subset of a. 

Return a list of all universal words in A.  You can return the words in any order.

**Example 1:**

```
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
Output: ["facebook","google","leetcode"]
```

**Example 2:**

```
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
Output: ["apple","google","leetcode"]
```

**Example 3:**

```
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
Output: ["facebook","google"]
```

**Example 4:**

```
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
Output: ["google","leetcode"]
```

**Example 5:**

```
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
Output: ["facebook","leetcode"]
```

## Solution


```java
public List<String> wordSubsets(String[] A, String[] B) {
    int[] bmax = frequency("");
    
    for (String s : B) {
        int[] count = frequency(s);
        for (int i = 0; i < 26; i++) {
            bmax[i] = Math.max(bmax[i], count[i]);
        }
    }
    
    List<String> res = new ArrayList<>();
    for (String s : A) {
        int[] count = frequency(s);
        boolean found = true;
        for (int i = 0; i < 26; i++) {
            if (bmax[i] > count[i]) {
                found = false;
                break;
            }
        }
        if (found)
            res.add(s);
    }
    
    return res;
}
```

**private helper  method**

```java
private int[] frequency(String s) {
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
        count[c - 'a']++;
    }
    return count;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/word-subsets/