import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        int best = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int unit = 0;
            for (int j = 1; j <= n; j++) {
                int steps = Math.abs(i - j) + (j - 1) + (i - 1);
                unit += (2 * a[j] * steps);
            }
            best = Math.min(best, unit);
        }
        System.out.println(best);
	}
}

class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStream stream) {
        try {
            br = new BufferedReader(new InputStreamReader(stream));
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
}