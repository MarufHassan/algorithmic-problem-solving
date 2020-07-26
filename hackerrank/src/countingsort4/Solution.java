import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String[] t = new String[2];
        StringBuilder[] string = new StringBuilder[100];

        for (int i = 0; i < n / 2; i++) {
            t = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int key = Integer.parseInt(t[0]);
            if (string[key] == null)
                string[key] = new StringBuilder();
            string[key] = string[key].append("- ");
        }

        for (int i = n / 2; i < n; i++) {
            t = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int key = Integer.parseInt(t[0]);
            if (string[key] == null)
                string[key] = new StringBuilder();
            string[key] = string[key].append(t[1]).append(" ");
        }

        for (int i = 0; i < string.length; i++) {
            if (string[i] != null)
                out.print(string[i]);
        }

        bufferedReader.close();
        out.close();
    }
}