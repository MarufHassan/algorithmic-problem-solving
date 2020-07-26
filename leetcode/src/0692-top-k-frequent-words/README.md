# [692. Top K Frequent Words][title]

## Problem Description

Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Detail instructions can be found [here][title].

**Example 1:**

```
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]

Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
```

**Example 2:**

```
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]

Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
```

## Solution

**Approach 1: Sorting**

```java
public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> freq = new HashMap<String, Integer>();
    for (String word : words) {
        int occur = freq.getOrDefault(word, 0);
        freq.put(word, occur + 1);
    }
    
    List<String> candidates = new ArrayList(freq.keySet());
    Collections.sort(candidates, new Comparator<String>() {
        public int compare(String word1, String word2) {
            int occur1 = freq.get(word1);
            int occur2 = freq.get(word2);
            if (occur1 < occur2)    return +1;
            if (occur1 > occur2)    return -1;
            return word1.compareTo(word2);
        }
    });
    return candidates.subList(0, k);
}
```

**Approach 2: Heap**

```java
public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> freq = new HashMap<String, Integer>();
    for (String word : words) {
        int occur = freq.getOrDefault(word, 0);
        freq.put(word, occur + 1);
    }
    PriorityQueue<String> pq = new PriorityQueue<>(k, new Comparator<String>() {
        public int compare(String word1, String word2) {
            int occur1 = freq.get(word1);
            int occur2 = freq.get(word2);
            if (occur1 != occur2)
                return occur1 - occur2;
            return word2.compareTo(word1);
        }
    });
    
    for (String word : freq.keySet()) {
        pq.offer(word);
        if (pq.size() > k)
            pq.poll();
    }
    List<String> candidates = new ArrayList<>();
    while (pq.size() > 0) {
        candidates.add(pq.poll());
    }
    Collections.reverse(candidates);
    return candidates;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/top-k-frequent-words/