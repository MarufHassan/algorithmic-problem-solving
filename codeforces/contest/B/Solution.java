import java.io.*;
import java.util.*;

public class Solution {
	public static void main (String[] args) {
	    FastScanner in = new FastScanner(System.in);
	    PrintWriter out = new PrintWriter(System.out);
	    
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        int max1 = -1, max2 = -1;
        for (int i = 0; i < n; i++) {
            int val = in.nextInt();
            if (val > max1) {
                max2 = max1;
                max1 = val;
            } else if (val > max2) {
                max2 = val;
            }
        }

        long h = 0;
        long total1 = (long)Math.floor((m * (k * 1.0) / (k + 1)));
        long total2 = (long) Math.floor((m * (1.0) / (k + 1)));
        h += (total1 * max1);
        h += total2 * max2;

        out.println(h);
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