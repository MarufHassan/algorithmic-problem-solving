import java.io.*;

class GFG {
    private static int find(int n, int m) {
        int q = n / m;
        int q1 = (m * n) < 0 ? q - 1 : q + 1;
        int d1 = Math.abs(n - (m * q));
        int d2 = Math.abs(n - (m * q1));
        return (d1 < d2) ? m * q : m * q1;
        
    }
    
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    while (t-- > 0) {
	        int n = in.nextInt();
	        int m = in.nextInt();
	        System.out.println(find(n, m));
	    }
	    in.close();
	}
}