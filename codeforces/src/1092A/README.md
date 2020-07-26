# [Uniform String][title]

## Problem Description

Detail instruction can be found [here][title].

## Solution

Compile with `javac Solution.java` and run with `java Solution`.

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            char[] result = new char[n];

            for (int i = 0; i < n; i++) {
                result[i] = (char) ('a' + i % k);
            }

            System.out.println(new String(result));
        }
    }
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://codeforces.com/contest/1092/problem/A