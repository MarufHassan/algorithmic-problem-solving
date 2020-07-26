# [970. Powerful Integers][title]

## Problem Description

Detailed description can be found [here][title]

**Example 1:**

```
Input: x = 2, y = 3, bound = 10
Output: [2,3,4,5,7,9,10]
Explanation: 
2 = 2^0 + 3^0
3 = 2^1 + 3^0
4 = 2^0 + 3^1
5 = 2^1 + 3^1
7 = 2^2 + 3^1
9 = 2^3 + 3^0
10 = 2^0 + 3^2
```

**Example 2:**

```
Input: x = 3, y = 5, bound = 15
Output: [2,4,6,8,10,14]
```

## Solution

**Approach 1:**

```java
public List<Integer> powerfulIntegers(int x, int y, int bound) {
    int[] xi = powers(x, bound);
    int[] yi = powers(y, bound);
    Set<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < xi.length; i++) {
        for (int j = 0; j < yi. length; j++) {
            if (xi[i] == 0 || yi[j] == 0)   break;
            if (xi[i] + yi[j] <= bound)
                set.add(xi[i] + yi[j]);
        }
    }
    return new ArrayList<Integer>(set);
}
```

**Helper Method**
```java
private int[] powers(int a, int bound) {
    if (a == 1)
        return new int[] {1};
    int size = (int)(Math.log(1000000) / Math.log(a));
    int[] arr = new int[size + 3];
    int i = 0, p = 1, mul = 1;
    arr[i++] = 1;
    while (mul <= bound) {
        arr[i++] = mul;
        mul *= a;
    }
    return arr;
}
```

**Approach 2:**

```java
public List<Integer> powerfulIntegers(int x, int y, int bound) {
    Set<Integer> seen = new HashSet<Integer>();
    
    for (int i = 0; i < 18 && Math.pow(x, i) <= bound; i++) {
        for (int j = 0; j < 18 && Math.pow(y, j) <= bound; j++) {
            int v = (int) Math.pow(x, i) + (int) Math.pow(y, j);
            if (v <= bound)
                seen.add(v);
        }
    }
    return new ArrayList<Integer>(seen);
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/powerful-integers