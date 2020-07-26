import java.util.*;
import java.io.*;

class GFG {
    private static int findMajority(int[] a) {
        int n = a.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int v : a) {
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }
        int lb = n / 2 + 1;
        for (int key : freq.keySet()) {
            if (freq.get(key) >= lb)
                return key;
        }
        return -1;
    }
    
	public static void main (String[] args) {
	    FastScanner in = new FastScanner(System.in);
	    int t = in.nextInt();
	    while (t-- > 0) {
	        int n = in.nextInt();
	        int[] a = new int[n];
	        for (int i = 0; i < n; i++) {
	            a[i] = in.nextInt();
	        }
	        System.out.println(findMajority(a));
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