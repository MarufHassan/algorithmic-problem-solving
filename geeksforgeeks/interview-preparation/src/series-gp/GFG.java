import java.util.*;
import java.io.*;

class GFG {
    private static double nth(int a, int b, int n) {
        double commonRatio = (b * 1.0) / a;
        return a * Math.pow(commonRatio, n - 1);
    }
    
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    while (t-- > 0) {
	        int a = in.nextInt();
	        int b = in.nextInt();
	        int n = in.nextInt();
	        int nth = (int) nth(a, b, n);
	        System.out.println(nth);
	    }
	    in.close();
	}
}