import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int hourglassSum(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                int sum = sum(arr, i, j);
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    static int sum(int[][] arr, int i, int j) {
        int sum = 0;
        sum += (arr[i][j] + arr[i][j + 1] + arr[i][j + 2]);
        sum += (arr[i + 1][j + 1]);
        sum += (arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]);
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
