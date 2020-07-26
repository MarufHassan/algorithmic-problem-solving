import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    private static int valueOf(char c) {
	if (c >= '0' && c <= '9')
	    return c - '0';
	else
	    return c - 'A' + 10;
    }

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	while (in.hasNext()) {
	    String s1 = in.next();
	    String s2 = in.next();

	    int hd1 = -1, hd2 = -1;
	    for (int i = 0; i < s1.length(); i++) {
		int val = valueOf(s1.charAt(i));
		if (val > hd1) {
		    hd1 = val;
		}
	    }
	    for (int i = 0; i < s2.length(); i++) {
		int val = valueOf(s2.charAt(i));
		if (val > hd2) {
		    hd2 = val;
		}
	    }
	    int b1 = -1, b2 = -1;
	    boolean isFound = false;
	    for (int i = hd1 + 1; i <= 36; i++) {
		if (i <= 1) {
		    b1 = 2;
		    b2 = 2;
		    break;
		}
		if (isFound)
		    break;
		BigInteger n1 = new BigInteger(s1, i);
		for (int j = hd2 + 1; j <= 36; j++) {
		    if (i <= 1)
			break;
		    if (n1.compareTo(new BigInteger(s2, j)) == 0) {
			b1 = i;
			b2 = j;
			isFound = true;
			break;
		    }
		}
	    }
	    if (b1 < 0 && b2 < 0) {
		System.out.printf("%s is not equal to %s in any base 2..36\n",
			s1, s2);
	    } else {
		System.out.printf("%s (base %d) = %s (base %d)\n", s1, b1, s2,
			b2);
	    }
	}
	in.close();
    }
}