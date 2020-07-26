import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    
    private static int gcdArray(int[] a, int n) {
        if (n <= 1)
            return a[n - 1];
        int gcd = gcd(a[0], a[1]);
        for (int i = 2; i < n; i++) {
            gcd = gcd(gcd, a[i]);
        }
        return gcd;
    }
    
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] a = new int[1000000];
        while (t-- > 0) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++)
                a[i] = in.nextInt();
            System.out.println(gcdArray(a, n));
        }
		in.close();
	}
}