# [Right-Left Cipher][title]

## Problem Description

Detail instraction can be found [here][title].

## Solution

```java
private static StringBuilder decrypt(String s) {
	int len = s.length();
	int left = (len - 1) / 2;
	int right = (len - 1) / 2;
	StringBuilder result = new StringBuilder();
	result.append(s.charAt(left));

	while (left >= 0 || right < len) {
		left--; right++;
		if (right < len) 	result.append(s.charAt(right));
		if (left >= 0) 		result.append(s.charAt(left));
	}
	return result;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

```java
import java.util.*;
import java.io.*;

public class Solution {
	private static StringBuilder decrypt(String s) {
		/* see previous code */
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		String s = in.next();
		
		out.println(decrypt(s));
		in.close();
		out.close();
	}
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://codeforces.com/contest/1087/problem/A