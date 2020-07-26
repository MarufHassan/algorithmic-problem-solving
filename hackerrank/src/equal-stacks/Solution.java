import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        int n1, n2, n3;
        n1 = h1.length - 1; n2 = h2.length - 1; n3 = h3.length - 1;

        reverse(h1);
        reverse(h2);
        reverse(h3);

        for (int i = 1; i <= n1; i++) h1[i] += h1[i - 1];
        for (int i = 1; i <= n2; i++) h2[i] += h2[i - 1];
        for (int i = 1; i <= n3; i++) h3[i] += h3[i - 1];

        while (h1[n1] != h2[n2] || h1[n1] != h3[n3]) {
            if (h1[n1] > h2[n2])    n1--;
            if (h1[n1] > h3[n3])    n1--;
            if (h2[n2] > h1[n1])    n2--;
            if (h2[n2] > h3[n3])    n2--;
            if (h3[n3] > h1[n1])    n3--;
            if (h3[n3] > h2[n2])    n3--;
        }

        return h1[n1];
    }

    static void reverse(int[] a) {
        int n = a.length;
        for (int i = 1; i <= n / 2; i++) {
            int t = a[i];
            a[i] = a[n - i];
            a[n - i] = t;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1 + 1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 1; h1Itr <= n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr - 1].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2 + 1];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 1; h2Itr <= n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr - 1].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3 + 1];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 1; h3Itr <= n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr - 1].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}