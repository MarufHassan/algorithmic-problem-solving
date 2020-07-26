import java.util.*;
import java.io.*;

class GFG {
    public static List<int[]> findPair(int[] a, int k) {
        List<int[]> pairs = new ArrayList<>();
        int n = a.length;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int sum = a[lo] + a[hi];
            if      (sum > k)    hi--;
            else if (sum < k)    lo++;
            else {
                pairs.add(new int[] {a[lo], a[hi]});
                lo++;
                hi--;
            }
        }
        return pairs;
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
            int k = in.nextInt();
            List<int[]> pairs = findPair(a, k);
            if (pairs.size() == 0) {
                out.println(-1);
                continue;
            }
            for (int[] v : pairs) {
                out.println(v[0] + " " + v[1] + " " + k);
            }
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