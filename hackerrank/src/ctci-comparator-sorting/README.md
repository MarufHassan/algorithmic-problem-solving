# [Sorting: Comparator][title]

## Problem Description

Detail description can be found [here][title].

**Example:**

```
    Input: 
        5
        amy 100
        david 100
        heraldo 50
        aakansha 75
        aleksa 150
    Output:
        aleksa 150
        amy 100
        david 100
        aakansha 75
        heraldo 50
```

## Solution

```java
public int compare(Player a, Player b) {
    if (a.score != b.score)
        return b.score - a.score;
    return a.name.compareTo(b.name);
}
```

## Test

Compile with `javac Checker.java` and run with `java Checker`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem