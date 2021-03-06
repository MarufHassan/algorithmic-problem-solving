# [904. Fruit Into Baskets][title]

## Problem Description

In a row of trees, the i-th tree produces fruit with type tree[i].

You start at any tree of your choice, then repeatedly perform the following steps:

Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.

You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.

What is the total amount of fruit you can collect with this procedure?

Detailed description can be found [here][title].

**Example 1:**

```
Input: [1,2,1]
Output: 3

Explanation: We can collect [1,2,1].
```

**Example 2:**

```
Input: [0,1,2,2]
Output: 3

Explanation: We can collect [1,2,2].
If we started at the first tree, we would only collect [0, 1].
```

**Example 3:**

```
Input: [1,2,3,2,2]
Output: 4

Explanation: We can collect [2,3,2,2].
If we started at the first tree, we would only collect [1, 2].
```

**Example 4:**

```
Input: [3,3,3,1,2,1,1,2,3,3,4]
Output: 5

Explanation: We can collect [1,2,1,1,2].
If we started at the first tree or the eighth tree, we would only collect 4 fruits.
```

## Solution

**Approach 1: Two pointers, linear time, constant space**

```java
public int totalFruit(int[] tree) {
    int anchor = 0, type1 = -1, type2 = -1;
    int i = 0, j = 0, n = tree.length;
    
    int total = 0;
    while (i < n && j < n) {
        type1 = tree[i];
        for (j = i + 1; j < n; j++) {
            if  (type1 == tree[j])
                type1 = tree[j];
            else if (type2 == -1 || type2 == tree[j])
                type2 = tree[j];
            else {  
                type1 = -1; type2 = -1;
                break;
            }
            if (tree[j] != tree[j - 1]) anchor = j;
        }
        total = Math.max(total, j - i);
        i = anchor;
    }
    return total;
}
```

**Approach 2: Sliding Window**

```java
public int totalFruit(int[] tree) {
    Map<Integer, Integer> count = new HashMap<Integer, Integer>();
    int i = 0, j;
    for (j = 0; j < tree.length; ++j) {
        count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
        if (count.size() > 2) {
            count.put(tree[i], count.get(tree[i]) - 1);
            if (count.get(tree[i]) == 0) count.remove(tree[i]);
            i++;
        }
    }
    return j - i;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/fruit-into-baskets/