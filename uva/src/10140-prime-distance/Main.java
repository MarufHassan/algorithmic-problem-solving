import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	Prime p = new Prime(46500);
	while (in.hasNextInt()) {
	    int L = in.nextInt();
	    int U = in.nextInt();
	    int max = Integer.MIN_VALUE;
	    int min = Integer.MAX_VALUE;
	    int ax = -1, ay = -1, bx = -1, by = -1;

	    int next = -1, prev = p.next(L - 1, U);
	    if (prev >= 0) {
		while (true) {
		    next = p.next(prev, U);
		    if (next <= 0)
			break;
		    int diff = next - prev;
		    if (diff > max) {
			max = diff;
			bx = prev;
			by = next;
		    }
		    if (diff < min) {
			min = diff;
			ax = prev;
			ay = next;
		    }
		    prev = next;
		}
	    }
	    if (max <= 0)
		System.out.println("There are no adjacent primes.");
	    else
		System.out.printf(
			"%d,%d are closest, %d,%d are most distant.\n", ax, ay,
			bx, by);
	}
	in.close();
    }
}

class Prime {
    private int seiveSize;
    private boolean[] marked; // 10^7 should be enough for most cases
    private List<Integer> primes; // compact list of primes

    public Prime(int upperBound) {
	this.seiveSize = upperBound;
	primes = new ArrayList<>();
	marked = new boolean[upperBound + 1];
	for (int i = 2; i <= seiveSize; i++) {
	    // initialize all entries as true. A value in marked[i]
	    // will finally be false if i is Not a prime, else true.
	    marked[i] = true;
	}
	for (long p = 2; p <= seiveSize; p++) {
	    // If prime[p] is not changed, then it is a prime
	    if (marked[(int) p]) {
		primes.add((int) p);
		// cross out multiples of i starting from i * i!
		for (long i = p * p; i <= seiveSize; i += p) {
		    marked[(int) i] = false;
		}
	    }
	}
    }

    public int next(long u, long range) {
	for (++u; u <= range; u++) {
	    if (isPrime(u)) {
		return (int) u;
	    }
	}
	return -1;
    }

    public boolean isPrime(long N) {
	if (N <= seiveSize)
	    return marked[(int) N]; // O(1) for small primes
	// it takes longer time if N is a large prime!
	// note: only work for N <= (last prime in list "primes")^2
	for (int i = 0; i < primes.size(); i++) {
	    if (primes.get(i) * primes.get(i) >= N)
		break;
	    if (N % primes.get(i) == 0)
		return false;
	}
	return true;
    }
}