import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    static int makeAnagram(String a, String b) {
        int[] frequency = new int[127];

        for (int i = 0; i < a.length(); i++) frequency[a.charAt(i)]++;
        for (int i = 0; i < b.length(); i++) frequency[b.charAt(i)]--;

        int remove = 0;
        for (int i = 0; i < 127; i++) {
            remove += Math.abs(frequency[i]);
        }

        return remove;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}