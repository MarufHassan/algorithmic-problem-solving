import java.util.*;
import java.io.*;

class GFG {
    private static long findHighestPrimeFactor(long n) {
        while (n % 2 == 0)
            n /= 2;
        int i;
        for (i = 3; i * i <= n; i += 2) {
            while (n % i == 0)
                n /= i;
        }
        return n > i ? n : i;
    }
    
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    while (t-- > 0) {
	        long n = in.nextLong();
	        System.out.println(findHighestPrimeFactor(n));
	    }
	    in.close();
	}
}