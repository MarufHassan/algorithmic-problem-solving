import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		while (t-- > 0) {
			int n = in.nextInt();
			int k = in.nextInt();

			char[] result = new char[n];

			for (int i = 0; i < n; i++) {
				result[i] = (char) ('a' + i % k);
			}

			System.out.println(new String(result));
		}
	}
}