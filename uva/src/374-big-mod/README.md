# Big mod

## Solution

```java
import java.util.Scanner;

public class Main {
    public static long powerMod(long base, long pow, long mod) {
	if (pow <= 0)
	    return 1;
	if (pow % 2 == 0) {
	    long ret = powerMod(base, pow / 2, mod);
	    return ((ret % mod) * (ret % mod)) % mod;
	} else
	    return ((base % mod) * (powerMod(base, pow - 1, mod) % mod)) % mod;
    }
    
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	while (in.hasNextInt()) {
	    int base = in.nextInt();
	    int pow = in.nextInt();
	    int mod = in.nextInt();
	    System.out.println(powerMod(base, pow, mod));
	}
	
	in.close();
    }
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**