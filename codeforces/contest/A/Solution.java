import java.io.*;
import java.util.*;

public class Solution {
	public static void main (String[] args) {
	    FastScanner in = new FastScanner(System.in);
	    PrintWriter out = new PrintWriter(System.out);

	    int n = in.nextInt();
	    int[] arr = new int[n];
	    int max = -1;
	    for (int i = 0; i < n; i++) {
	    	arr[i] = in.nextInt();
	    	if (arr[i] > max)
	    		max = arr[i];
	    }
	    
	    int maxLength = 0;
	    int i = 0;
	    while (i < n) {
	    	int j = i + 1;
	    	if (arr[i] == max) {
	    		while (j < n && arr[j] == max) {
	    			j++;
	    		}
	    		maxLength = Math.max(maxLength, j - i);
	    	}
	    	i = j;
	    }
	    out.println(maxLength);
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