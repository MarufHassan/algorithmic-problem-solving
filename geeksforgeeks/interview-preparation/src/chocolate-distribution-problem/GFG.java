import java.util.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        FastScanner in = new FastScanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }
            int m = in.nextInt();
            Arrays.sort(a);
            long min = Long.MAX_VALUE;
            for (int i = m - 1; i < n; i++) {
                min = Math.min(min, (a[i] - a[i - m + 1]));
            }
            System.out.println(min);
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