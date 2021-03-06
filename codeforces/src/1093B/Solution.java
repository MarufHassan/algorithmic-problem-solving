import java.util.*;
import java.io.*;

public class Solution {
    private static boolean isPalindrome(char[] chars) {
        int n = chars.length;
        for (int i = 0; i < n / 2; i++) {
            if (chars[i] != chars[n - i - 1])
                return false;
        }
        return true;
    }

    private static char[] nonPalindrome(char[] str) {
        int n = str.length;
        char[] frequency = new char[128];
        for (int i = 0; i < n; i++) {
            frequency[str[i]]++;
        }
        for (int i = 0, k = 0; i < 128; i++) {
            if (frequency[i] != 0) {
                for (int j = 1; j <= frequency[i]; j++) {
                    str[k++] = (char) i;
                }
            }
        }
        return str;
    }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);		
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            String istr = in.next();
            char[] str = nonPalindrome(istr.toCharArray());
            if (isPalindrome(str))
                System.out.print(-1);
            else {
                for (int j = 0; j < str.length; j++) {
                    System.out.print(str[j]);
                }
            }
            System.out.println();
        }
	}
}