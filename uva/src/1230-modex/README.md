# Modex

## Solution

```java
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	BigInteger base, pow, mod;
	int c = in.nextInt();
	while (c-- > 0) {
	    base = BigInteger.valueOf(in.nextInt());
	    pow = BigInteger.valueOf(in.nextInt());
	    mod = BigInteger.valueOf(in.nextInt());
	    System.out.println(base.modPow(pow, mod));
	}
	in.close();
    }
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**