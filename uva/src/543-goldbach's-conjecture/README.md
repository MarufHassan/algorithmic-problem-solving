# Goldbach's conjecture

## Solution

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	Prime p = new Prime(1000000);
	while (true) {
	    int n = in.nextInt();
	    if (n == 0)
		break;

	    for (int a = 3; a <= n; a++) {
		if (p.isPrime(a)) {
		    int b = n - a;
		    if (p.isPrime(b)) {
			System.out.printf("%d = %d + %d\n", n, a, b);
			break;
		    }
		}
	    }
	}
	in.close();
    }
}

class Prime {
    private int seiveSize;
    private boolean[] marked;
    private List<Integer> primes;

    public Prime(int upperBound) {
	this.seiveSize = upperBound;
	marked = new boolean[upperBound + 1];
	primes = new ArrayList<>();

	for (int i = 2; i <= upperBound; i++) {
	    marked[i] = true;
	}

	for (int p = 2; p <= seiveSize; p++) {
	    if (marked[p]) {
		primes.add((int) p);
		for (int i = p * 2; i <= seiveSize; i += p) {
		    marked[i] = false;
		}
	    }
	}
    }

    public boolean isPrime(int n) {
	return marked[n];
    }
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**