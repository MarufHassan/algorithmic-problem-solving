import java.util.*;
import java.io.*;

class GFG {
    
    private static void makeWave(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i += 2) {
            int t = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = t;
        }
    }
    
	public static void main (String[] args) {
	    FastScanner in = new FastScanner(System.in);
	    PrintWriter out = new PrintWriter(System.out);
	    int t = in.nextInt();
	    while (t-- > 0) {
	        int n = in.nextInt();
	        int[] arr = new int[n];
	        for (int i = 0; i < n; i++) 
	            arr[i] = in.nextInt();
	        makeWave(arr);
	        for (int i = 0; i < n; i++) 
	            out.print(arr[i] + " ");
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