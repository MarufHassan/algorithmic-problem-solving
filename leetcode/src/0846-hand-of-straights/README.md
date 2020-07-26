# [846. Hand of Straights][title]

## Problem Description

Alice has a hand of cards, given as an array of integers.

Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.

Return true if and only if she can.

**Example 1:**

```
Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
Output: true

Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
```

**Example 2:**

```
Input: hand = [1,2,3,4,5], W = 4
Output: false

Explanation: Alice's hand can't be rearranged into groups of 4.
```

## Solution

```java
public boolean isNStraightHand(int[] hand, int W) {
    if (hand.length % W != 0)   return false;
    
    TreeMap<Integer, Integer> freq = new TreeMap<>();
    for (int card : hand) {
        freq.put(card, freq.getOrDefault(card, 0) + 1);
    }
    
    while (freq.size() > 0) {
        int first = freq.firstKey();
        for (int card = first; card < W + first; card++) {
            if (!freq.containsKey(card))    return false;
            int val = freq.get(card);
            if (val > 1)
                freq.replace(card, val - 1);
            else
                freq.remove(card);
        }
    }
    return true;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/hand-of-straights/