# [791. Custom Sort String][title]

## Problem Description

S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

**Example 1:**

```
Example :
Input: 
S = "cba"
T = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
```

## Solution

**Approach 1: Counting**

```java
public String customSortString(String S, String T) {
    int[] count = new int[26];
    StringBuilder ans = new StringBuilder();
    
    for (char c : T.toCharArray()) {
        count[c - 'a']++;
    }
    
    for (char c : S.toCharArray()) {
        while (count[c - 'a']-- > 0) ans.append(c);
    }
    
    for (char c = 'a'; c <= 'z'; c++) {
        while (count[c - 'a']-- > 0) ans.append(c);
    }
    
    return ans.toString();
}
```

**Approach 2: Sorting with comparator**

```java
public String customSortString(String S, String T) {
    int[] map = new int[26];
    Arrays.fill(map, 27);
    
    int count = 0;
    for (char c : S.toCharArray()) {
        map[c - 'a'] = count++;
    }
    
    Character[] ans = toCharArray(T);
    Arrays.sort(ans, new Comparator<Character>() {
        public int compare(Character c1, Character c2) {
            return map[c1 - 'a'] - map[c2 - 'a'];
        }
    });
    
    return valueOf(ans);
}
```

**private helper  methods**

```java
private Character[] toCharArray(String s) {
    Character[] chars = new Character[s.length()];
    for (int i = 0; i < chars.length; i++) {
        chars[i] = s.charAt(i);
    }
    return chars;
}

private String valueOf(Character[] chars) {
    StringBuilder s = new StringBuilder();
    for (char c : chars) {
        s.append(c);
    }
    return s.toString();
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/word-subsets/