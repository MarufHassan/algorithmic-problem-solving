# [Luck Balance][title]

## Problem Description

Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        6 3
        5 1
        2 1
        1 1
        8 1
        10 0
        5 0
    Output:
        29
```

## Solution


```java
static int luckBalance(int k, int[][] contests) {
    int luck = 0;
    int important = 0;
    int n = contests.length;
    int start = 0;

    // group the unimportant contests in the beginning
    // so that we can sort the remaining
    for (int i = 0; i < n; i++) {
        if (contests[i][1] == 0) {
            luck += contests[i][0];
            exch(contests, i, start++);
        }
    }

    // sort the unimportant contests according to their luck value
    Arrays.sort(contests, start, n, new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
        }
    });

    for (int i = n - 1; i >= start; i--) {
        important++;
        if (important <= k) {
            luck += contests[i][0];
        } else {
            luck -= contests[i][0];
        }
    }
    return luck;
}

private static void exch(int[][] a, int i, int j) {
    int[] t = a[i];
    a[i] = a[j];
    a[j] = t;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.




**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/luck-balance