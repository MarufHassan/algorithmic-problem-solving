import java.util.Scanner;

public class P11965 {

    private static StringBuilder removeSpaces(StringBuilder sb) {
		int n = sb.length();
		int i = 0, j = 0;
		boolean spaceFound = false;
		while (j < n) {
		    if (sb.charAt(j) != ' ') {
				sb.setCharAt(i++, sb.charAt(j++));
				spaceFound = false;
		    } else if (sb.charAt(j++) == ' ') {
				if (!spaceFound) {
				    sb.setCharAt(i++, ' ');
				    spaceFound = true;
				}
		    }
		}
		sb.delete(i, n);
		return sb;
    }

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		
		for (int t = 1; t <= tc; t++) {
		    int n = in.nextInt();
		    in.nextLine();
		    System.out.printf("Case %d:\n", t);
		    for (int i = 0; i < n; i++) {
			System.out.println(removeSpaces(new StringBuilder(in.nextLine())));
		    }
		    if (t < tc)	System.out.println();
		}
		in.close();
    }

}
