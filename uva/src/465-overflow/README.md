# Overflow

## Solution

```java
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int max = Integer.MAX_VALUE;
		String splits[];
		BigInteger num1, num2, result = BigInteger.ZERO;
		char operator;
		
		while (in.hasNext()) {
			String line = in.nextLine();
			System.out.println(line);
			splits = line.split("\\s+");
			num1 = new BigInteger(splits[0]);
			operator = splits[1].charAt(0);
			num2 = new BigInteger(splits[2]);
			
			if (operator == '+') 		result = num1.add(num2);
			else if (operator == '*')	result = num1.multiply(num2);
			
			System.out.println(line);
			if (num1.compareTo(BigInteger.valueOf(max)) > 0)
				System.out.println("first number too big");
			if (num2.compareTo(BigInteger.valueOf(max)) > 0)
				System.out.println("second number too big");
			if (result.compareTo(BigInteger.valueOf(max)) > 0)
				System.out.println("result too big");
		}
		
		in.close();
	}
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**