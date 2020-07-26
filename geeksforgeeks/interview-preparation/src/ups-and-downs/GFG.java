import java.io.*;

class GFG {
	public static void main (String[] args) {
	    FastScanner in = new FastScanner(System.in);
	    int t = in.nextInt();
	    while (t-- > 0) {
	        int n = in.nextInt();
	        int[] a = new int[n];
	        for (int i = 0; i < n; i++) {
	            a[i] = in.nextInt();
	        }
	        int ups = 0, downs = 0;
	        int i = 1;
	        while (i + 1 < n) {
	            if (a[i] > a[i - 1] && a[i] > a[i + 1])
	                ups++;
	            if (a[i] < a[i - 1] && a[i] < a[i + 1])
	                downs++;
	            i++;
	        }
	        System.out.println(ups + " " + downs);
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