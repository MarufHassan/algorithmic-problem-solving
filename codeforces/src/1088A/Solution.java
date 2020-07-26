import java.util.*;

public class Solution {
	private static int[] find(int n) {
		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= n; b++) {
				if ((a % b == 0) && (a * b) > n && (a / b) < n)
					return new int[] {a, b};
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int[] ans = find(n);
		if (ans == null)
			System.out.println(-1);
		else
			System.out.println(ans[0] + " " + ans[1]);

		s.close();
	}
}