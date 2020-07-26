# [Quicksort 1 - Partition][title]

## Problem Description

Given _arr_ and _p_ = _arr[0]_, partition _arr_ into _left_, _right_, and _equal_ using the Divide instructions above. Then print each element in  followed by each element in _left_, followed by each element in _equal_ on a single line. Your output should be space-separated and does not have to maintain ordering of the elements within the three categories. Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        5
        4 5 3 7 2
    Output:
        3 2 4 5 7
```

## Solution

```java
static int[] quickSort(int[] arr) {
    int p = arr[0];
    int lo = 0, hi = arr.length - 1;
    int lt = lo, gt = hi;
    int i = lo + 1;

    while (i <= gt) {
        if      (arr[i] < p)    exch(arr, i++, lt++);
        else if (arr[i] > p)    exch(arr, i, gt--);
        else                    i++;
    }

    return arr;
}
```

**Helper Method**
```java
static void exch(int[] arr, int i, int j) {
    int swap = arr[i];
    arr[i] = arr[j];
    arr[j] = swap;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/quicksort1