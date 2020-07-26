import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	while (true) {
	    int b = in.nextInt();
	    if (b == 0)
		break;
	    String s = in.next();
	    BigInteger p = new BigInteger(s, b);
	    int m = Integer.parseUnsignedInt(in.next(), b);
	    System.out.println(p.mod(BigInteger.valueOf(m)).toString(b));
	}
	in.close();
    }
}