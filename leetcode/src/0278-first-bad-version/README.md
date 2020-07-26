# [278. First Bad Version][title]

## Problem

Detail instruction can be found [here][title].


## Solution


```java
public int firstBadVersion(int n) {
    int lo = 1, hi = n;
    int ans = -1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (isBadVersion(mid)) {
            ans = mid;
            hi = mid - 1;
        } else 
            lo = mid + 1;
    }
    return ans;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/first-bad-version/