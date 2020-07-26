import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			BigInteger n = in.nextBigInteger();
			if (n.compareTo(new BigInteger("0")) == 0) break;
			
			if (n.mod(new BigInteger("17")).compareTo(new BigInteger("0")) == 0)
				System.out.println(1);
			else 	
				System.out.println(0);
		}
		in.close();
	}
}
