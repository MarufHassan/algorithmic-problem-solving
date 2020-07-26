import java.util.*;
import java.io.*;

class GFG {
    public static long[] products(int[] a) {
        int n = a.length;
        long product = 1;
        for (int i = 0; i < n; i++) {
            product *= a[i];
        }
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            ans[i] = product / a[i];
        }
        return ans;
    }
    
	public static void main (String[] args) {
	    FastScanner in = new FastScanner(System.in);
	    PrintWriter out = new PrintWriter(System.out);
	    int t = in.nextInt();
	    while (t-- > 0) {
	        int n = in.nextInt();
	        int[] a = new int[n];
	        for (int i = 0; i < n; i++) {
	            a[i] = in.nextInt();
	        }
	        for (long v : products(a)) {
	            out.print(v + " ");
	        }
	        out.println();
	    }
	    out.close();
	}
}

class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStream stream) {
        try {
            br = new BufferedReader(new
                    InputStreamReader(stream));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }
    
    long nextLong() {
        return Long.parseLong(next());
    }
}