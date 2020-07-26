# Basically speaking

## Solution

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	while (in.hasNext()) {
	    String num = in.next();
	    int fromBase = in.nextInt();
	    int toBase = in.nextInt();
	    int converted = Integer.parseInt(num, fromBase);
	    StringBuilder s = new StringBuilder(Integer.toUnsignedString(
		    converted, toBase).toUpperCase());
	    int len = 7 - s.length();
	    for (int i = 1; i <= len; i++) {
		s.insert(0, ' ');
	    }
	    if (s.length() > 7) {
		System.out.printf("%7s\n", "ERROR");
	    } else {
		System.out.println(s);
	    }
	}
	in.close();
    }
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**