# [Triangular Number][title]

## Problem Description

Check whether the number is Triangular or not. A number is termed as triangular number if we can represent it in the form of triangular grid of points such that the points form an equilateral triangle and each row contains as many points as the row number, i.e., the first row has one point, second row has two points, third row has three points and so on. The starting triangular numbers are 1, 3 (1+2), 6 (1+2+3), 10 (1+2+3+4).

Detailed description can be found [here][title]

**Example:**

```
Input
	5
    3
    4
    6
    55
    345
Output
	1
    0
    1
    1
    0
```

## Solution

```java
private static int find(int n) {
    for (int i = (int) Math.sqrt(n); i >= 0; i--) {
        if (n % i == 0) {
            int t = n / i;
            if (Math.abs(i - t) == 1)
                return 1;
            else
                return 0;
        }
    }
    return 0;
}

public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
        int n = in.nextInt();
        System.out.println(find(2 * n));
    }
    in.close();
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/squares-in-a-matrix/0/