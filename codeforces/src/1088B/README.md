# [Ehab and subtraction][title]

## Problem Description

Detail instraction can be found [here][title].

## Solution

```java
private static int[] minNonZeroElement(int[] a, int operation) {
    int n = a.length;
    int[] answer = new int[operation];
    Arrays.sort(a);

    int base = 0;
    for (int i = 0, k = 0; i < n && k < operation; i++) {
    	if (a[i] > base) {
            answer[k++] = a[i] - base;
        }
        base = a[i];
    }
    return answer;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

```java
import java.util.*;
import java.io.*;

public class Solution {
    private static int[] minNonZeroElement(int[] a, int operation) {
        /* see previous code */
    }

	public static void main(String[] args) {
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		int[] answer = minNonZeroElement(a, k);
		for (int i : answer) {
			out.println(i);
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

[title]: https://codeforces.com/contest/1088/problem/B