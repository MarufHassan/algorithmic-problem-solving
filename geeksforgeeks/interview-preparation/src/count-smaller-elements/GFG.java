import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    FastScanner in = new FastScanner(System.in);
	    PrintWriter out = new PrintWriter(System.out);
	    int t = in.nextInt();
	    while (t-- > 0) {
	        Set<Integer> sets = new LinkedHashSet<Integer>();
	        int n = in.nextInt();
	        for (int i = 0; i < n; i++) {
	            sets.add(in.nextInt());
	        }
	        for (int v : sets) {
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