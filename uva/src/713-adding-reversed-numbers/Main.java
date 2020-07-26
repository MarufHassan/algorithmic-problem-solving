import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)  {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		StringBuilder sb;
		BigInteger num1, num2;
		for (int t = 0; t < n; t++) {
			sb = new StringBuilder(in.next());
			num1 = new BigInteger(sb.reverse().toString());
			
			sb = new StringBuilder(in.next());
			num2 = new BigInteger(sb.reverse().toString());
			
			sb = new StringBuilder(num1.add(num2).toString());
			System.out.println(new BigInteger(sb.reverse().toString()));
		}
		in.close();
	}
}
