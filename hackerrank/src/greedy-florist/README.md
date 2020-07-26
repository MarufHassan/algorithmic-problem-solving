# [Greedy Florist][title]

## Problem Description
Given the size of the group of friends, the number of flowers they want to purchase and the original prices of the flowers, determine the minimum cost to purchase all of the flowers.
Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        3 3
        2 5 6
    Output:
        13
```

**Example 2:**

```
    Input: 
        3 2
        2 5 6
    Output:
        15
```

**Example 3:**

```
    Input: 
        5 3
        1 3 5 7 9
    Output:
        29
```

## Solution


```java
static int getMinimumCost(int k, int[] original) {
    int n = original.length;
    int multiplier = 1;
    int price = 0;

    Arrays.sort(original);

    for (int i = n - 1; i = 0; i--) {
        price += (original[i]  multiplier);
        if ((n - i) % k == 0)
            multiplier++;
    }
    return price;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/greedy-florist