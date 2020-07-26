# [Perfect Numbers][title]

## Problem Description

Given a number N, check if a number is perfect or not. A number is said to be perfect if sum of all its factors excluding the number itself is equal to the number. Detailed description can be found [here][title]

**Example:**

```
Input
	2
    6
    21
Output
	1
    0
```

## Solution

```java
private static int isPerfect(long n) {
    if (n <= 1)
        return 0;
    long sum = 1;
    for (long i = 2; i * i <= n; i++) {
        if (n % i == 0) {
            sum += i;
            if (i * i < n)
                sum += (n / i);
        }
    }
    return (sum == n) ? 1 : 0;
}
```

**Driver Program**

```java
import java.util.*;
import java.io.*;

class GFG {
    private static int isPerfect(long n) {
        /* see previous code */
    }
    
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            System.out.println(isPerfect(n));
        }

        in.close();
    }
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/perfect-numbers/0/