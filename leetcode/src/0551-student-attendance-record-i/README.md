# [551. Student Attendance Record I][title]

## Problem Description

Detail instruction can be found [here][title].

**Example 1:**

```
Input: "PPALLP"
Output: True
```

**Example 2:**

```
Input: "PPALLL"
Output: False
```

## Solution

```java
public boolean checkRecord(String s) {
    int absent = 0;
    for (char c : s.toCharArray()) {
        if (c == 'A')   absent++;
    }
    return absent <= 1 && !s.contains("LLL");
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/student-attendance-record-i/