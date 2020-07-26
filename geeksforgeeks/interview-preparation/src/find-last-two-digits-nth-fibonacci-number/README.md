# [Last two digits of Fibonacci][title]

## Problem Description

Detailed description can be found [here][title]

**Example:**

```
Input
	8
	1
	2
	3
	4
	5
	6
	7
	8
Output
	1
	1
	2
	3
	5
	8
	13
	21
```

## Solution


```java
import java.util.*;

class GFG {
    private static final int P_LENGTH = 300; // pisano length of 100
    
    private static int lastDigitFib(int n) {
        int limit = n % P_LENGTH;
		    
	    int previous = 0;
        int current  = 1;

        for (int i = 0; i < limit - 1; ++i) {
            int tmpPrevious = previous;
            previous = current;
            current = (tmpPrevious + current) % 100;
        }
        return current;
    }
    
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
		    int n = in.nextInt();
            System.out.println(lastDigitFib(n));
		}
		in.close();
	}
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.geeksforgeeks.org/program-find-last-two-digits-nth-fibonacci-number/