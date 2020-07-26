import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
	    
	    int t = in.nextInt();
	    while (t-- > 0) {
	        int n = in.nextInt();
	        int count = 0;
	        for (int a = 1; a <= 18; a++) {
	            for (int b = 0; b <= 18; b++) {
	                int p = a * a * a;
	                int q = b * b * b;
	                if (p + q == n)
	                    count++;
	            }
	        }
	        System.out.println(count);
	    }
	    
	    in.close();
    }
}