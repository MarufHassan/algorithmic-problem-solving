# Divisors

## Solution

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int tests = in.nextInt();
	for (int t = 1; t <= tests; t++) {
	    int L = in.nextInt();
	    int U = in.nextInt();

	    int maxDivisorCount = Integer.MIN_VALUE;
	    int maxNumber = -1;
	    for (int i = L; i <= U; i++) {
		int divisorCount = divisorCount(i);
		if (divisorCount > maxDivisorCount) {
		    maxDivisorCount = divisorCount;
		    maxNumber = i;
		}
	    }
	    System.out.printf(
		    "Between %d and %d, %d has a maximum of %d divisors.\n", L,
		    U, maxNumber, maxDivisorCount);
	}

	in.close();
    }

    private static int divisorCount(int n) {
	int count = 1;
	while (n % 2 == 0) {
	    count++;
	    n /= 2;
	}
	for (int i = 3; i * i <= n; i += 2) {
	    int pow = 0;
	    while (n % i == 0) {
		pow++;
		n /= i;
	    }
	    count *= (pow + 1);
	}
	if (n > 2)
	    count *= (1 + 1);
	return count;
    }
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**