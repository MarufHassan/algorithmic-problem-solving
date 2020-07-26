# [56. Merge Intervals][title]

## Problem Description

Given a collection of intervals, merge all overlapping intervals.

**Example 1:**

```
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]

Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
```

**Example 2:**

```
Input: [[1,4],[4,5]]
Output: [[1,5]]

Explanation: Intervals [1,4] and [4,5] are considered overlapping.
```

## Solution

```java
public List<Interval> merge(List<Interval> intervals) {
    List<Interval> res = new ArrayList<>();
    if (intervals.size() == 0) return res;
    
    Collections.sort(intervals, new Comparator<Interval>() {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    });
    
    Interval interval = intervals.get(0);
    int start = interval.start, end = interval.end;
    
    for (int i = 1; i < intervals.size(); i++) {
        interval = intervals.get(i);
        if (interval.start > end) {
            res.add(new Interval(start, end));
            start = interval.start;
        }
        if (interval.end > end)
            end = interval.end;
    }
    res.add(new Interval(start, end));
    return res;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/merge-intervals/