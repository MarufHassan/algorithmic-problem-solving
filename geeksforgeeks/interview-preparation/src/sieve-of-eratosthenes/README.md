# [Sieve of Eratosthenes][title]

## Problem Description

Given a number N, calculate the prime numbers upto N using Sieve of Eratosthenes. Detailed description can be found [here][title]

**Example:**

```
Input
	2
    10
    35
Output
	2 3 5 7
    2 3 5 7 11 13 17 19 23 29 31 
```

## Solution

```java
private static List<Integer> generate(int n) {
    boolean[] checked = new boolean[n + 1];
    List<Integer> primes = new ArrayList<Integer>();
    for (int i = 2; i <= n; i++) {
        if (!checked[i]) {
            primes.add(i);
            for (int m = i; m <= n; m += i)
                checked[m] = true;
        }
    }
    return primes;
}
```

**Driver Program**

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    private static List<Integer> generate(int n) {
        /* see previous code */
    }
    
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            for (int p : generate(n)) {
                out.print(p + " ");
            }
            out.println();
        }
        out.close();
        in.close();
    }
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.geeksforgeeks.org/sieve-of-eratosthenes/