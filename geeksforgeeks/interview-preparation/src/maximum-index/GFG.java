import java.util.*;
import java.io.*;

class GFG {
    public static int maxWidthRamp(int[] A) {
        int n = A.length;
        Integer[] index = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        
        Arrays.sort(index, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(A[i1], A[i2]);
            }
        });
        
        int m = n, max = 0;
        for (int i : index) {
            max = Math.max(i - m, max);
            m = Math.min(i, m);
        }
        
        return max;
    }
    
	public static void main (String[] args) {
	    FastScanner in = new FastScanner(System.in);
	    int t = in.nextInt();
	    while (t-- > 0) {
	        int n = in.nextInt();
	        int[] arr = new int[n];
	        
	        for (int i = 0; i < n; i++) {
	            arr[i] = in.nextInt();
	        }
	        System.out.println(maxWidthRamp(arr));
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