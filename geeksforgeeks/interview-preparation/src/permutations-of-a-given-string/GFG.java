import java.util.*;
import java.io.*;

class GFG {
    private static FastScanner in = new FastScanner(System.in);
    private static PrintWriter out = new PrintWriter(System.out);
    
    private static void swap(char[] str, int i, int j) {
        char c = str[i];
        str[i] = str[j];
        str[j] = c;
    }
    
    private static void permute(char[] str, int left, int right, Set<String> sets) {
        if (left == right) {
            sets.add(new String(str));
        } else {
            for (int i = left; i <= right; i++) {
                swap(str, i, left);
                permute(str, left + 1, right, sets);
                swap(str, i, left);
            }
        }
    }
    
	public static void main (String[] args) {
	    int t = in.nextInt();
	    while (t-- > 0) {
	        char[] str = in.next().toCharArray();
	        Set<String> sets = new TreeSet<>();
	        permute(str, 0, str.length - 1, sets);
	        
	        for (String s : sets) {
	            out.print(s);
	            out.print(" ");
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