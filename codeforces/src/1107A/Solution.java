import java.io.*;
import java.util.*;

public class Solution {
	public static void main (String[] args) {
	    FastScanner in = new FastScanner(System.in);
	    PrintWriter out = new PrintWriter(System.out);
	    
	    int q = in.nextInt();
	    while (q-- > 0) {
	    	int n = in.nextInt();
	    	String s = in.next();
	    	if (n == 2 && s.charAt(0) >= s.charAt(1)) {
                out.println("NO");
	    	} else {
	    		out.println("YES\n" + 2);
	    		out.println(s.charAt(0) + " " + s.substring(1, s.length()));
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