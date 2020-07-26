# [Ehab and another construction problem][title]

## Problem Description

Detail instraction can be found [here][title].

## Solution

```java
private static int[] find(int n) {
	for (int a = 1; a <= n; a++) {
		for (int b = 1; b <= n; b++) {
			if ((a % b == 0) && (a * b) > n && (a / b) < n)
				return new int[] {a, b};
		}
	}
	return null;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

```java
import java.util.*;

public class Solution {
	private static int[] find(int n) {
		/* see previous code */
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int[] ans = find(n);
		if (ans == null)
			System.out.println(-1);
		else
			System.out.println(ans[0] + " " + ans[1]);

		s.close();
	}
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://codeforces.com/contest/1088/problem/A