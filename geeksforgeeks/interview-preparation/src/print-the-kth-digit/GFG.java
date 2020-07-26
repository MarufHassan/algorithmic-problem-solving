import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    while (t-- > 0) {
	        int a = in.nextInt();
	        int b = in.nextInt();
	        int k = in.nextInt();
	        long p = (long) Math.pow(a, b);
	        while (k-- > 1)
	            p /= 10;
	        System.out.println(p % 10);
	    }
	    in.close();
	}
}