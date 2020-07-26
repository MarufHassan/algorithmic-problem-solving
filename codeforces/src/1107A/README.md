# [Digits Sequence Dividing][title]

## Problem Description

Detail instraction can be found [here][title].

## Solution

Compile with `javac Solution.java` and run with `java Solution`.

```java
public static void main (String[] args) {
    FastScanner in = new FastScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int q = in.nextInt();
    while (q-- > 0) {
        int n = in.nextInt();
        String s = in.next();
        if (n == 2 && s.charAt(0) >= s.charAt(1)) {
            out.println("NO");
        } else {
            out.println("YES\n" + 2);
            out.println(s.charAt(0) + " " + s.substring(1, s.length()));
        }
    }

    out.close();
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://codeforces.com/contest/1107/problem/A