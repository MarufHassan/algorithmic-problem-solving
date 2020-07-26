# [Closest Number][title]

## Problem Description

Given non-zero two integers N and M. The problem is to find the number closest to N and divisible by M. If there are more than one such number, then output the one having maximum absolute value. Detailed description can be found [here][title]

**Example:**

```
Input
	2
    13 4
    -15 6
Output
	12
    -18
```

## Solution

```java
private static int find(int n, int m) {
    int q = n / m;
    int q1 = (m * n) < 0 ? q - 1 : q + 1;
    int d1 = Math.abs(n - (m * q));
    int d2 = Math.abs(n - (m * q1));
    return (d1 < d2) ? m * q : m * q1;
    
}
```

**Driver Program**

```java
import java.io.*;

class GFG {
    private static int find(int n, int m) {
        /* see previous code */
        
    }
    
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println(find(n, m));
        }
        in.close();
    }
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/closest-number/0/