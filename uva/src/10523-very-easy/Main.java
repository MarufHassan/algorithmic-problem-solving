import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)  {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int N = in.nextInt();
			int A = in.nextInt();
			BigInteger num = new BigInteger(String.valueOf(A));
			BigInteger result = new BigInteger("0");
			for (int i = 1; i <= N; i++) {
				result = result.add(num.pow(i).multiply(BigInteger.valueOf(i)));
			}
			System.out.println(result);
		}
		in.close();
	}
}
