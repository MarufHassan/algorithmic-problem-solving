# [121. Best Time to Buy and Sell Stock][title]

## Problem Description

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: [7,1,5,3,6,4]
Output: 5

Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
```

**Example 2:**

```
Input: [7,6,4,3,1]
Output: 0

Explanation: In this case, no transaction is done, i.e. max profit = 0.
```

## Solution

**Approach 1: One pass**

```java
public int maxProfit(int[] prices) {
    if (prices.length == 0)
        return 0;
    int n = prices.length;
    int[] sells = new int[n];
    int minprice = prices[0], maxprofit = 0;
    
    for (int i = 1; i < n; i++) {
        if (prices[i] < minprice)
            minprice = prices[i];
        maxprofit = Math.max(prices[i] - minprice, maxprofit);
    }
    
    return maxprofit;
}
```

**Approach 2: Dynamic Programming**

```java
public int maxProfit(int[] prices) {
    if (prices.length == 0)
        return 0;
    int n = prices.length;
    int[] sells = new int[n];
    
    sells[n - 1] = prices[n - 1];
    for (int i = n - 2; i >= 0; i--) {
        sells[i] = Math.max(sells[i + 1], prices[i]);
    }
    
    int maxprofit = 0;
    for (int i = 0; i < n; i++) {
        int profit = sells[i] - prices[i];
        maxprofit = Math.max(profit, maxprofit);
    }
    return maxprofit;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/