# [Three way partitioning][title]

## Problem Description

Given an array A and a range [lowVal, highVal]. The task is to complete the function  threeWayPartition which partition the array around the range such that array is divided in three parts.
1) All elements smaller than lowVal come first.
2) All elements in range lowVal to highVal come next.
3) All elements greater than highVal appear in the end.
The individual elements of three sets can appear in any order. You are required to return the modified arranged array.

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    5
    1 2 3 3 4
    1 2
    3
    1 2 3
    1 3
Output
	1
    1
```

## Solution

**Submitting linear running time java code surprisingly gives TLE**

```java
public ArrayList<Integer> threeWayPartition(ArrayList<Integer> a, int lowVal, int highVal) {
    int lt = 0, gt = a.size() - 1;
    int i = lt;
    while (gt >= i) {
        if      (a.get(i) < lowVal)  exch(a, lt++, i++);
        else if (a.get(i) > highVal) exch(a, i, gt--);
        else                         i++;
    }
    return a;
}

private void exch(ArrayList<Integer> a, int i, int j) {
    int swap = a.get(i);
    a.set(i, a.get(j));
    a.set(j, swap);
}
```

**Same logic in C++ is okay**

```c++
vector<int> threeWayPartition(vector<int> a, int lowVal, int highVal)
{
    int lt = 0, gt = a.size() - 1;
    int i = lt;
    while (gt >= i) {
        if      (a[i] < lowVal)  swap(a[lt++], a[i++]);
        else if (a[i] > highVal) swap(a[i], a[gt--]);
        else                         i++;
    }
    return a;
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/three-way-partitioning/1/