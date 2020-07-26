import java.util.*;
import java.io.*;

class GFG {
    private static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    while (t-- > 0) {
	        int n = in.nextInt();
	        int count = 0;
	        for (int i = 2; i * i <= n; i++) {
	            if (isPrime(i))
	                count++;
	        }
	        System.out.println(count);
	    }
	    in.close();
	}
}