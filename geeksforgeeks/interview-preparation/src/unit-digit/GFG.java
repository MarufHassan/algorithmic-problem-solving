import java.util.*;
import java.io.*;

class GFG {
    private static int unitDigit(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 6;
        if (n == 4) return 4;
        return 0;
    }
    
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    while (t-- > 0) {
	        long n = in.nextLong();
	        System.out.println(unitDigit(n));
	    }
	    in.close();
	}
}