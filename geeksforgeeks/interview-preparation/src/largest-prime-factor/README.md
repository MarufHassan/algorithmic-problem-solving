# [Largest prime factor][title]

## Problem Description

Given a number N, the task is to find the largest prime factor of that number.

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    6
    15
Output
	3
    5
```

## Solution

```java
private static long findHighestPrimeFactor(long n) {
    while (n % 2 == 0)
        n /= 2;
    int i;
    for (i = 3; i * i <= n; i += 2) {
        while (n % i == 0)
            n /= i;
    }
    return n > i ? n : i;
}
```

**Driver Program**

```java
import java.util.*;
import java.io.*;

class GFG {
    private static long findHighestPrimeFactor(long n) {
        /* see previous code */
    }
    
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            System.out.println(findHighestPrimeFactor(n));
        }
        in.close();
    }
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/largest-prime-factor/0/