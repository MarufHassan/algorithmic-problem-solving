import java.util.*;
import java.io.*;

class GFG {
    private static int[] maximumSubArray(int[] arr) {
        int n = arr.length;
        int start = 0, i = 0, j = 0;
        int maxSum = 0, maxLength = 0, sum = 0;
        
        while (i < n) {
            while (i < n && arr[i] < 0)
                i++;
                
            j = i;
            sum = 0;
            while (j < n && arr[j] >= 0) 
                sum += arr[j++];
            
            if (sum > maxSum) {
                maxSum = sum;
                start = i;
                maxLength = j - i;
            } else if (sum == maxSum && j - i > maxLength) {
                start = i;
                maxLength = j - i;
            }
            i = j;
        }
        
        int[] ans = new int[maxLength];
        for (i = 0; i < maxLength; i++) {
            ans[i] = arr[i + start];
        }
        return ans;
    }
    
	public static void main (String[] args) {
	    FastScanner in = new FastScanner(System.in);
	    PrintWriter out = new PrintWriter(System.out);
	    int t = in.nextInt();
	    while (t-- > 0) {
	        int n = in.nextInt();
	        int[] arr = new int[n];
	        for (int i = 0; i < n; i++) {
	            arr[i] = in.nextInt();
	        }
	        for (int v : maximumSubArray(arr)) {
	            out.print(v + " ");
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