# [Sum of all prime numbers between 1 and N][title]

## Problem Description

Given a positive integer N, calculate the sum of all prime numbers between 1 and N(inclusive). Detailed description can be found [here][title]

**Example:**

```
Input
	2
    5
    10
Output
	10
    17
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

private static long sum(int n) {
    long sum = 0;
    for (int p : generate(n))
        sum += p;
    return sum;
}
```

**Driver Program**

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {    
    private static long sum(int n) {
        /* see previous code */
    }
    
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            out.println(sum(n));
        }
        out.close();
        in.close();
    }
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.geeksforgeeks.org/program-find-sum-prime-numbers-1-n/