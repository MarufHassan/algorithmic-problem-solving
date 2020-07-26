# [Two distinct points][title]

## Problem Description

Detail instraction can be found [here][title].

## Solution

Compile with `javac Solution.java` and run with `java Solution`.

```java
import java.util.*;
import java.io.*;

public class Solution {
    public static void main (String[] args) {
	    FastScanner in = new FastScanner(System.in);
	    PrintWriter out = new PrintWriter(System.out);
	    int q = in.nextInt();
        while (q-- > 0) {
            int l1 = in.nextInt();
            int r1 = in.nextInt();
            int l2 = in.nextInt();
            int r2 = in.nextInt();
            int p1 = l1, p2 = l2;
            if (p1 == p2)
                p2 = r2;
            out.println(p1 + " " + p2);
        }
	    out.close();
	}
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://codeforces.com/contest/1108/problem/A