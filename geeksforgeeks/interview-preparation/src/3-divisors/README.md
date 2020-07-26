# [3 Divisors][title]

## Problem Description

Given a value N, you need to find how many numbers less than or equal to N have numbers of divisors exactly equal to 3. Detailed description can be found [here][title]

**Example:**

```
Input
	3
    6
    10
    30
Output
	1
    2
    3
```

## Solution

```java
public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
        int n = in.nextInt();
        int count = 0;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime(i))
                count++;
        }
        System.out.println(count);
    }
    in.close();
}
```

**Helper Method**

```java
private static boolean isPrime(int n) {
    if (n <= 1)
        return false;
    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0)
            return false;
    }
    return true;
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/3-divisors/0