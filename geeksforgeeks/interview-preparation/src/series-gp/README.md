# [Series GP][title]

## Problem Description

Given the first 2 terms A and B of a Geometric Series, tell the Nth term of the series. Detailed description can be found [here][title]

**Example:**

```
Input
	2
    2 3
    1
    1 2
    2
Output
	2
    2
```

## Solution

```java
private static double nth(int a, int b, int n) {
    double commonRatio = (b * 1.0) / a;
    return a * Math.pow(commonRatio, n - 1);
}
```

**Driver Program**

```java
public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        int nth = (int) nth(a, b, n);
        System.out.println(nth);
    }
    in.close();
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/series-gp/0/