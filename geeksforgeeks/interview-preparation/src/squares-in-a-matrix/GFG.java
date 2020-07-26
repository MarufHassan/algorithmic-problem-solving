import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    while (t-- > 0) {
	        int m = in.nextInt();
	        int n = in.nextInt();
	        if (m > n) {
	            int tmp = m;
	            m = n;
	            n = tmp;
	        }
	        long mSquare = (m * (m + 1)*(2L * m + 1)) / 6;
	        long increased = m * (m + 1L) / 2;
	        long total = mSquare + (n - m) * increased;
	        System.out.println(total);
	    }
	    in.close();
	}
}