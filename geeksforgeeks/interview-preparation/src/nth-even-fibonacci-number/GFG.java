import java.util.*;
import java.io.*;

class GFG {
    public static long[] preCompute() {
        long[] fibs = new long[1001];
        long m = 1000000007;
        
        long prev = 1, curr = 1, ldPrev = 1, ldCurr = 1;
        for (int i = 3, j = 1; i < 3003; i++) {
            long tmpPrev = curr, tmpldPrev = ldCurr;
            curr = (prev + curr) % m;
            ldCurr = (ldPrev + ldCurr) % 10;
            if (ldCurr % 2 == 0) {
                fibs[j++] = curr;
            }
            prev = tmpPrev;
            ldPrev = tmpldPrev;
        }
        
        return fibs;
    }
    
    public static void main (String[] args) {
        FastScanner in = new FastScanner(System.in);
        long[] fibs = preCompute();
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            System.out.println(fibs[n]);
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