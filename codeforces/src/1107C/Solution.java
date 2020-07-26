import java.io.*;
import java.util.*;

public class Solution {
	public static void main (String[] args) {
	    FastScanner in = new FastScanner(System.in);
	    PrintWriter out = new PrintWriter(System.out);
	    
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        
        char[] s = in.next().toCharArray();
        PriorityQueue<Integer> pq;

        long count = 0;
        for (int i = 0; i < n; ) {
            int j = i + 1;
            pq = new PriorityQueue<>();
            pq.add(nums[i]);
            while (j < n) {
                if (s[i] != s[j])
                    break;
                pq.add(nums[j]);
                if (pq.size() > k)
                    pq.poll();
                j++;
            }
            while (!pq.isEmpty()) {
                count += pq.poll();
            }
            i = j;
        }
        out.println(count);

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