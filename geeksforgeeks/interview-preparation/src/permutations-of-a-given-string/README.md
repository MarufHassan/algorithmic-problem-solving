# [Permutations of a given string][title]

## Problem Description

Given a string S. The task is to print all permutations of a given string.

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    ABC
    ABSG
Output
	ABC ACB BAC BCA CAB CBA 
    ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA
```

## Solution

```java
private static void swap(char[] str, int i, int j) {
    char c = str[i];
    str[i] = str[j];
    str[j] = c;
}

private static void permute(char[] str, int left, int right, Set<String> sets) {
    if (left == right) {
        sets.add(new String(str));
    } else {
        for (int i = left; i <= right; i++) {
            swap(str, i, left);
            permute(str, left + 1, right, sets);
            swap(str, i, left);
        }
    }
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0