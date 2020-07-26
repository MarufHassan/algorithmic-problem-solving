# [Digital root][title]

## Problem Description

Detail instraction can be found [here][title].

## Solution

Compile with `javac Solution.java` and run with `java Solution`.

```java
public static void main (String[] args) {
    FastScanner in = new FastScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = in.nextInt();
    while (n-- > 0) {
        long k = in.nextLong();
        int x = in.nextInt();
        out.println(x + (9 * k) - 9);
    }
    out.close();
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://codeforces.com/contest/1107/problem/B