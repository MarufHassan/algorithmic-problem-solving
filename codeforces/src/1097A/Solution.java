import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		String table = in.next();
		char c = table.charAt(0);
		for (int i = 0; i < 5; i++) {
			String card = in.next();
			if (table.charAt(0) == card.charAt(0) ||
					table.charAt(1) == card.charAt(1)) {
				System.out.println("YES");
				return;
			}
		}

		System.out.println("NO");

		in.close();
		out.close();
	}
}