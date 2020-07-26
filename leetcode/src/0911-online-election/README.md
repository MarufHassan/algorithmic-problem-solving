# [911. Online Election][title]

## Problem Description

In an election, the i-th vote was cast for persons[i] at time times[i].

Now, we would like to implement the following query function: TopVotedCandidate.q(int t) will return the number of the person that was leading the election at time t.  

Votes cast at time t will count towards our query.  In the case of a tie, the most recent vote (among tied candidates) wins.

**Example 1:**

```
Input: ["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
Output: [null,0,1,1,0,0,1]

Explanation: 
At time 3, the votes are [0], and 0 is leading.
At time 12, the votes are [0,1,1], and 1 is leading.
At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
This continues for 3 more queries at time 15, 24, and 8.
```

## Solution

```java
public TopVotedCandidate(int[] persons, int[] times) {
    index = new TreeMap<>();
    leaders = new int[persons.length];
    
    for (int i = 0; i < times.length; i++) {
        index.put(times[i], i);
    }
    
    Map<Integer, Integer> freq = new HashMap<>();
    int leader = persons[0];
    for (int i = 0; i < persons.length; i++) {
        freq.put(persons[i], freq.getOrDefault(persons[i], 0) + 1);
        
        int votes = freq.get(persons[i]);
        if (votes >= freq.get(leader))
            leader = persons[i];
        leaders[i] = leader;
    }
}
```

```java
public int q(int t) {
    int idx = index.floorEntry(t).getValue();
    return leaders[idx];
}
```

## Test

Compile with `javac TopVotedCandidate.java` and run with `java TopVotedCandidate`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/online-election/