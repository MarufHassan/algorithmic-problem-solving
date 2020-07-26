import java.io.*;
import java.util.*;

public class Solution {
    public static List<Integer> factors(int n) {
        List<Integer> divs = new ArrayList<Integer>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
            divs.add(i);
                if (i * i < n) divs.add(n / i);
            }
        }
        return divs;
    }

	public static void main (String[] args) {
	    FastScanner in = new FastScanner(System.in);
	    PrintWriter out = new PrintWriter(System.out);
	    
        int n = in.nextInt();
        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {            
            a.add(in.nextInt());
        }

        Collections.sort(a);
        int d1 = a.get(n - 1);
        List<Integer> factors = factors(a.get(n - 1));
        for (Integer f : factors) {
            a.remove(f);
        }
        
        int d2 = a.get(a.size() - 1);
        
        out.println(d1 + " " + d2);
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