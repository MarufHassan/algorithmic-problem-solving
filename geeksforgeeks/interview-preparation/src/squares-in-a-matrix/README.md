# [Squares in a Matrix][title]

## Problem Description

Given a MxN matrix, count the number of squares in the matrix.

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    2 2
    4 3
Output
	5
    20
```

## Solution

```java
public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
        int m = in.nextInt();
        int n = in.nextInt();
        if (m > n) {
            int tmp = m;
            m = n;
            n = tmp;
        }
        long mSquare = (m * (m + 1)*(2L * m + 1)) / 6;
        long increased = m * (m + 1L) / 2;
        long total = mSquare + (n - m) * increased;
        System.out.println(total);
    }
    in.close();
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/squares-in-a-matrix/0/