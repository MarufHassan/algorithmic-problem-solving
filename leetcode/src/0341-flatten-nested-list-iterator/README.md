# [341. Flatten Nested List Iterator][title]

## Problem Description

Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

**Example 1:**

```
Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]

Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,1,2,1,1].
```

**Example 2:**

```
Input: [1,[4,[6]]]
Output: [1,4,6]

Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,4,6].
```

## Solution

```java
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> list;
    private int N;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        N = 0;
        flatten(nestedList);
    }
    
    private void flatten(List<NestedInteger> nestedList) {
        for (NestedInteger nl : nestedList) {
            if (nl.isInteger())
                list.add(nl.getInteger());
            else
                flatten(nl.getList());
        }
    }

    @Override
    public Integer next() {
        return list.get(N++);
    }

    @Override
    public boolean hasNext() {
        return N != list.size();
    }
}
```

## Test


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/flatten-nested-list-iterator/