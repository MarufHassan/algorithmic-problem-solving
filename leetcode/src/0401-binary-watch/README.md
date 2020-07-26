# [401. Binary Watch][title]

## Problem Description

A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Detailed description can be found [here][title].

**Example:**

```
Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
```

## Solution

```java
public List<String> readBinaryWatch(int num) {
    ans = new ArrayList<>();
    
    for (int n = 0; n <= num; n++) {
        List<Integer> hourlist = new ArrayList<>();
        List<Integer> minutelist = new ArrayList<>();
        generateHours(n, 0, 0, hourlist);
        generateMinutes(num - n, 0, 0, minutelist);
        
        for (int h : hourlist) {
            if (h >= 12) continue;
            for (int m : minutelist) {
                if (m > 59) continue;
                String time = String.format("%d:%02d", h, m);
                ans.add(time);
            }
        }
    }
    
    return ans;
}
```

**private helper methods**

```java
private void generateHours(int num, int hour, int offset, List<Integer> collect) {
    if (num <= 0) {
        collect.add(hour);
        return;
    }
    if (offset >= hours.length) return;
    
    generateHours(num - 1, hour + hours[offset], offset + 1, collect);
    generateHours(num, hour, offset + 1, collect);
}
```

```java
private void generateMinutes(int num, int minute, int offset, List<Integer> collect) {
    if (num <= 0) {
        collect.add(minute);
        return;
    }
    if (offset >= minutes.length) return;
    
    generateMinutes(num - 1, minute + minutes[offset], offset + 1, collect);
    generateMinutes(num, minute, offset + 1, collect);
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/binary-watch/