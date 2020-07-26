# [The Fair Nut and Elevator][title]

## Problem Description

Detail instraction can be found [here][title].

## Solution

```java
public static void main(String[] args) {
    FastScanner scanner = new FastScanner(System.in);

    int n = scanner.nextInt();
    int[] a = new int[n + 1];

    for (int i = 1; i <= n; i++) {
        a[i] = scanner.nextInt();
    }

    int best = Integer.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
        int unit = 0;
        for (int j = 1; j <= n; j++) {
            int steps = Math.abs(i - j) + (j - 1) + (i - 1);
            unit += (2 * a[j] * steps);
        }
        best = Math.min(best, unit);
    }
    System.out.println(best);
}
```

**Faster I/O**

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

[title]: https://codeforces.com/contest/1084/problem/A