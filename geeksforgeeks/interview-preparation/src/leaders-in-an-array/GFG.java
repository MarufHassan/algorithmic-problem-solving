import java.util.*;
import java.io.*;

class GFG {
    public static List<Integer> findLeader(int[] a) {
        int n = a.length; 
        List<Integer> candidates = new ArrayList<>();
        int i = n - 1;
        candidates.add(a[i]);
        while (i >= 0) {
            int j = i - 1;
            while (j >= 0 && a[j] < a[i])
                j--;
            if (j >= 0)
                candidates.add(a[j]);
            i = j;
        }
        Collections.reverse(candidates);
        return candidates;
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
	        for (int v : findLeader(a)) {
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