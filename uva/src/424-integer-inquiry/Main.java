import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)  {
		Scanner in = new Scanner(System.in);
		BigInteger sum = BigInteger.ZERO;
		while (in.hasNextLine()) {
			String line = in.nextLine();
			if (line.charAt(0) == '0')	break;
			sum = sum.add(new BigInteger(line));
		}
		System.out.println(sum);
		in.close();
	}
}
