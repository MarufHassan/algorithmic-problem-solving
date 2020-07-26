import java.util.*;
import java.io.*;

class GFG {
    public static int trap(int[] height) {
        int amount = 0;
        
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax)
                    leftMax = height[left];
                else
                    amount += (leftMax - height[left]);
                left++;
            } else {
                if (height[right] >= rightMax)
                    rightMax = height[right];
                else
                    amount += (rightMax - height[right]);
                right--;
            }
        }
        
        return amount;
    }
    
    public static void main (String[] args) {
        FastScanner in = new FastScanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = in.nextInt();
            System.out.println(trap(a));
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