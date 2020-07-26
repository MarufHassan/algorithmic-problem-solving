# [118. Pascal's Triangle][title]

## Problem Description

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

**Example 1:**

```
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```

## Solution

```java
public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<>();
    if (numRows <= 0)   return triangle;
    
    triangle.add(Arrays.asList(1));
    
    for (int i = 1; i < numRows; i++) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> prev = triangle.get(i - 1);
        
        rows.add(1);
        for (int j = 1; j < i; j++) {
            rows.add(prev.get(j - 1) + prev.get(j));
        }
        rows.add(1);
        triangle.add(rows);
    }
    
    return triangle;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/pascals-triangle/