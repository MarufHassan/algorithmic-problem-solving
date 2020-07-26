# [539. Minimum Time Difference][title]

## Problem Description

Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.

**Example 1:**

```
Input: ["23:59","00:00"]
Output: 1
```

## Solution

**Approach 1: Sorting**

```java
public int findMinDifference(List<String> timePoints) {
    int ans = Integer.MAX_VALUE;
    List<Integer> times = new ArrayList<>();
    
    for (String time : timePoints) {
        int minute = toMinute(time);
        times.add(minute);
    }
    
    Collections.sort(times);
    
    int minute1, minute2;
    for (int i = 1; i < timePoints.size(); i++) {
        
        minute1 = times.get(i);
        minute2 = times.get(i - 1);
        
        ans = Math.min(ans, diff(minute1, minute2));
        
    }
    minute1 = times.get(0);
    minute2 = times.get(times.size() - 1);
    ans = Math.min(ans, diff(minute1, minute2));
    return ans;
}
```

**private helper  methods**

```java
private int diff(int t1, int t2) {
    int a = Math.abs(t1 - t2);
    int b = t1 + (1440 - t2);
    int c = t2 + (1440 - t1);
    return Math.min(a, Math.min(b, c));
}

private int toMinute(String time) {
    String[] s = time.split(":");
    int h = Integer.parseInt(s[0]);
    int m = Integer.parseInt(s[1]);
    return h * 60 + m;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/minimum-time-difference/