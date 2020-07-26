# [819. Most Common Word][title]

## Problem Description

Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]

Output: "ball"

Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
```

## Solution

```java
public String mostCommonWord(String paragraph, String[] banned) {
    Map<String, Integer> freq = new HashMap<>();
    
    for (String s : split(paragraph)) {
        freq.put(s, freq.getOrDefault(s, 0) + 1);
    }
    
    Set<String> banset = new HashSet<>();
    for (String s: banned) {
        banset.add(s);
    }
    
    PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
        public int compare(String s1, String s2) {
            return freq.get(s2) - freq.get(s1);
        }
    });
    
    for (String key : freq.keySet()) {
        pq.offer(key);
    }
    
    while (!pq.isEmpty()) {
        String s = pq.poll();
        if (!banset.contains(s))
            return s;
    }
    
    return null;
}
```

**private helper methods**

```java
private List<String> split(String s) {
    List<String> list = new ArrayList<>();
    int i = 0;
    while (i < s.length()) {
        while (i < s.length() && !Character.isLetter(s.charAt(i)))
            i++;
        
        StringBuilder word = new StringBuilder();
        
        while (i < s.length() && Character.isLetter(s.charAt(i))) {
            word.append(Character.toLowerCase(s.charAt(i)));
            i++;
        }
        if (word.length() > 0)
            list.add(word.toString());
    }
    return list;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/most-common-word/