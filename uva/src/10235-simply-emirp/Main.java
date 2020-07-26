import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	Prime p = new Prime(1000000);

	while (in.hasNextInt()) {
	    StringBuilder sb = new StringBuilder(in.next());
	    int num = Integer.parseInt(sb.toString());
	    int revNum = Integer.parseInt(sb.reverse().toString());

	    if (!p.isPrime(num)) {
		System.out.printf("%d is not prime.\n", num);
	    } else if (p.isPrime(num)) {
		if (p.isPrime(revNum) && num != revNum)
		    System.out.printf("%d is emirp.\n", num);
		else
		    System.out.printf("%d is prime.\n", num);
	    }
	}

	in.close();
    }
}

class Prime {
    private int seiveSize;
    private boolean[] marked;

    public Prime(int upperBound) {
	this.seiveSize = upperBound;
	marked = new boolean[upperBound + 1];

	for (int i = 2; i <= seiveSize; i++) {
	    // initialize all entries as true. A value in marked[i]
	    // will finally be false if i is Not a prime, else true.
	    marked[i] = true;
	}
	for (long p = 2; p <= seiveSize; p++) {
	    // If prime[p] is not changed, then it is a prime
	    if (marked[(int) p]) {
		// cross out multiples of i starting from i * i!
		for (long i = p * p; i <= seiveSize; i += p) {
		    marked[(int) i] = false;
		}
	    }
	}
    }

    public boolean isPrime(long N) {
	return marked[(int) N];
    }
}