# [Print the Kth Digit][title]

## Problem Description

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    3 3 1
    5 2 2
Output
	7
    2
```

## Solution

```java
public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
        int a = in.nextInt();
        int b = in.nextInt();
        int k = in.nextInt();
        long p = (long) Math.pow(a, b);
        while (k-- > 1)
            p /= 10;
        System.out.println(p % 10);
    }
    in.close();
}
```


## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/print-the-kth-digit/0/