/*package whatever //do not write package name here */

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
    
    private static long sum(int n) {
        long sum = 0;
        for (int p : generate(n))
            sum += p;
        return sum;
    }
    
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		while (t-- > 0) {
		    int n = in.nextInt();
		    out.println(sum(n));
		}
		out.close();
		in.close();
	}
}