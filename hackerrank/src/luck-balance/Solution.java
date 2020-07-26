import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int luckBalance(int k, int[][] contests) {
        int luck = 0;
        int important = 0;
        int n = contests.length;
        int start = 0;

        // group the unimportant contests in the beginning
        // so that we can sort the remaining
        for (int i = 0; i < n; i++) {
            if (contests[i][1] == 0) {
                luck += contests[i][0];
                exch(contests, i, start++);
            }
        }

        // sort the unimportant contests according to their luck value
        Arrays.sort(contests, start, n, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        for (int i = n - 1; i >= start; i--) {
            important++;
            if (important <= k) {
                luck += contests[i][0];
            } else {
                luck -= contests[i][0];
            }
        }
        return luck;
    }

    private static void exch(int[][] a, int i, int j) {
        int[] t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}