import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long sum = n * (n + 1) / 2;
		System.out.println(sum % 2);
    }
}