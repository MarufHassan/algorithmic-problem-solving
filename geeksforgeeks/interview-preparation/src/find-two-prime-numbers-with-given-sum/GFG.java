import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    private static List<Integer> generate(int n) {
        boolean[] checked = new boolean[n + 1];
        List<Integer> primes = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            if (!checked[i]) {
                primes.add(i);
                for (int m = i; m <= n; m += i)
                    checked[m] = true;
            }
        }
        return primes;
    }
    
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    while (t-- > 0) {
	        int n = in.nextInt();
	        List<Integer> primes = generate(n);
	        for (int p : primes) {
	            for (int q : primes) {
	                if (p * q <= n)
	                    System.out.print(p + " " + q + " ");
	            }
	        }
	        System.out.println();
	    }
	    
	    in.close();
	}
}