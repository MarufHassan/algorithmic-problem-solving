# [Dice Rolling][title]

## Problem Description

Detail instraction can be found [here][title].

## Solution

Compile with `javac Solution.java` and run with `java Solution`.

```java
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int x = in.nextInt();
            int ans = -1;
            if (x % 2 == 0)
                ans = x / 2;
            if (x % 2 == 1)
                ans = (x / 2 - 1) + 1;
            System.out.println(ans);
        }

        out.close();
    }
}
```

**Faster Input**

```java
class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStream stream) {
        try {
            br = new BufferedReader(new InputStreamReader(stream));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://codeforces.com/contest/1093/problem/A