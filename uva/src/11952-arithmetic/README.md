# Arithmetic

## Solution

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int tests = in.nextInt();
	while (tests-- > 0) {
	    String a = in.next();
	    in.next();
	    String b = in.next();
	    in.next();
	    String c = in.next();

	    if (a.matches("1+") && b.matches("1+") && c.matches("1+")
		    && (a.length() + b.length() == c.length())) {
		System.out.println("1");
		continue;
	    }

	    int base = -1;
	    boolean isFound = false;
	    for (int i = 2; i <= 18; i++) {
		if (isFound)
		    break;
		try {
		    int operand1 = Integer.parseInt(a, i);
		    int operand2 = Integer.parseInt(b, i);
		    int result = Integer.parseInt(c, i);
		    if (operand1 + operand2 == result) {
			isFound = true;
			base = i;
			break;
		    }
		} catch (NumberFormatException e) {
		}
	    }
	    if (isFound)
		System.out.println(base);
	    else
		System.out.println("0");
	}

	in.close();
    }
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**