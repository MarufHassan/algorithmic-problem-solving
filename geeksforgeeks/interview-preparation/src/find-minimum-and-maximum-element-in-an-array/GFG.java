import java.util.*;
import java.io.*;

class GFG {
    private static int minIndex(long[] a) {
        int min = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < a[min])
                min = i;
        }
        return min;
    }
    
    private static int maxIndex(long[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > a[max])
                max = i;
        }
        return max;
    }
    
	public static void main (String[] args) {
	    FastScanner in = new FastScanner(System.in);
	    int t = in.nextInt();
	    while (t-- > 0) {
	        int n = in.nextInt();
	        long[] a = new long[n];
	        for (int i = 0; i < n; i++) 
	            a[i] = in.nextLong();
	        int min = minIndex(a);
	        int max = maxIndex(a);
	        System.out.print(a[min] + " " + a[max]);
	        System.out.println();
	    }
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