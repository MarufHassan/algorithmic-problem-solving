# [Add two fractions][title]

## Problem Description

You are given four numbers num1, den1, num2, and den2. You need to find (num1/den1)+(num2/den2) and output the result in the form of (numx/denx). Detailed description can be found [here][title]

**Example:**

```
Input
	1
    1 500 2 500
Output
	3/500
```

## Solution

```java
void addFraction(int num1, int den1, int num2, int den2)
{
    int den = lcm(den1, den2);
    int num = (den / den1 * num1) + (den / den2 * num2);
    int gcd = gcd(num, den);
    den = den / gcd;
    num = num / gcd;
    System.out.println(num + "/" + den);
}
```

**Helper Method**

```java
int gcd(int a, int b) {
    if (a == 0)
        return b;
    return gcd(b % a, a);
}

int lcm(int a, int b) {
    return (a * b) / gcd(a, b);
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/add-two-fractions/1/