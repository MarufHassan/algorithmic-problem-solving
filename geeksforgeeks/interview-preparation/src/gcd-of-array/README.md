# [GCD of Array][title]

## Problem Description

Given an array of `N` positive integers. Your task is to find the `GCD` of all numbers of the array. Detailed description can be found [here][title]

**Example:**

```
Input
	1
	2
	5 10
Output
	5
```

## Solution


```java
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    
    private static int gcdArray(int[] a, int n) {
        if (n <= 1)
            return a[n - 1];
        int gcd = gcd(a[0], a[1]);
        for (int i = 2; i < n; i++) {
            gcd = gcd(gcd, a[i]);
        }
        return gcd;
    }
    
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] a = new int[1000000];
        while (t-- > 0) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++)
                a[i] = in.nextInt();
            System.out.println(gcdArray(a, n));
        }
		in.close();
	}
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.geeksforgeeks.org/gcd-two-array-numbers/