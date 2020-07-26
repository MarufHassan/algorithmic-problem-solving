import java.util.*;
import java.io.*;

class GFG {
    private static int isPerfect(long n) {
        if (n <= 1)
            return 0;
        long sum = 1;
		for (long i = 2; i * i <= n; i++) {
		    if (n % i == 0) {
		    	sum += i;
		    	if (i * i < n)
		    	    sum += (n / i);
		    }
		}
		return (sum == n) ? 1 : 0;
    }
    
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
        int t = in.nextInt();
		while (t-- > 0) {
		    long n = in.nextLong();
		    System.out.println(isPerfect(n));
		}

		in.close();
	}
}