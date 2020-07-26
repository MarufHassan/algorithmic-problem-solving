# [451. Sort Characters By Frequency][title]

## Problem Description

Given a string, sort it in decreasing order based on the frequency of characters.

Detail instructions can be found [here][title].

**Example 1:**

```
Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
```

**Example 2:**

```
Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
```

**Example 3:**

```
Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
```

## Solution

```java
public String frequencySort(String s) {
    int[] freq = new int[128];
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        freq[c] += 1;
    }
    PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
        public int compare(Character c1, Character c2) {
            int f1 = freq[c1];
            int f2 = freq[c2];
            if (f1 != f2)
                return f2 - f1;
            return Character.compare(c1, c2);
        }
    });
    for (int i = 0; i < 128; i++) {
        if (freq[i] != 0) {
            pq.offer((char)i);
        }
    }
    StringBuilder ans = new StringBuilder();
    while (pq.size() > 0) {
        char c = pq.poll();
        for (int i = 0; i < freq[c]; i++) {
            ans.append(c);
        }
    }
    return ans.toString();
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/sort-characters-by-frequency/