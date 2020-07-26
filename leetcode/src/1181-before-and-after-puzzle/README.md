# [1181. Before and After Puzzle][title]

## Problem Description

Given a list of phrases, generate a list of Before and After puzzles.

A phrase is a string that consists of lowercase English letters and spaces only. No space appears in the start or the end of a phrase. There are no consecutive spaces in a phrase.

Before and After puzzles are phrases that are formed by merging two phrases where the last word of the first phrase is the same as the first word of the second phrase.

Return the Before and After puzzles that can be formed by every two phrases phrases[i] and phrases[j] where i != j. Note that the order of matching two phrases matters, we want to consider both orders.

You should return a list of distinct strings sorted lexicographically.

**Example 1:**

```
Input: phrases = ["writing code","code rocks"]
Output: ["writing code rocks"]
```

**Example 2:**

```
Input: phrases = ["mission statement",
                  "a quick bite to eat",
                  "a chip off the old block",
                  "chocolate bar",
                  "mission impossible",
                  "a man on a mission",
                  "block party",
                  "eat my words",
                  "bar of soap"]
Output: ["a chip off the old block party",
         "a man on a mission impossible",
         "a man on a mission statement",
         "a quick bite to eat my words",
         "chocolate bar of soap"]
```

## Solution

```java
public List<String> beforeAndAfterPuzzles(String[] phrases) {
    TreeSet<String> ans = new TreeSet<>();
    
    String[] first = new String[phrases.length];
    String[] last = new String[phrases.length];
    
    for (int i = 0; i < phrases.length; i++) {
        String[] splits = phrases[i].split(" ");
        first[i] = splits[0];
        last[i] = splits[splits.length - 1];
    }
    
    for (int i = 0; i < phrases.length; i++) {
        for (int j = 0; j < phrases.length; j++) {
            if (i == j) continue;
            if (last[i].equals(first[j])) {
                int idx = phrases[j].indexOf(" ");
                String make = phrases[i];
                if (idx != -1) {
                    make += phrases[j].substring(idx, phrases[j].length());
                }
                ans.add(make);
            }
        }
    }
    
    return new ArrayList<>(ans);
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/before-and-after-puzzle/