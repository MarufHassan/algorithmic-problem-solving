# [Teams Forming][title]

## Problem Description

Detail instruction can be found [here][title].

## Solution

Compile with `javac Solution.java` and run with `java Solution`.

```java
public class Solution {
    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        Arrays.sort(a);

        int count = 0;
        for (int i = 0; i < n; i += 2) {
            count += (a[i + 1] - a[i]);
        }
        System.out.println(count);
    }
}
```

## Faster I/O

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

[title]: https://codeforces.com/contest/1092/problem/B