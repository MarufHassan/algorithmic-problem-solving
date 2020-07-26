# [Pair cube count][title]

## Problem Description

Given a number N, calculate the prime numbers upto N using Sieve of Eratosthenes. Detailed description can be found [here][title]

**Example:**

```
Input
	2
    9
    28
Output
	2
    2
```

## Solution

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int count = 0;
            for (int a = 1; a <= 18; a++) {
                for (int b = 0; b <= 18; b++) {
                    int p = a * a * a;
                    int q = b * b * b;
                    if (p + q == n)
                        count++;
                }
            }
            System.out.println(count);
        }
        
        in.close();
    }
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.geeksforgeeks.org/count-pairs-a-b-whose-sum-of-cubes-is-n-a3-b3-n/