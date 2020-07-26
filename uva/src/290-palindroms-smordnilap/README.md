# Palindroms --- smordnilaP

## Solution

```java
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    private static int valueOf(char c) {
	if (c >= '0' && c <= '9')
	    return c - '0';
	else
	    return c - 'A' + 10;
    }

    private static boolean isPalindrome(String s) {
	int i = 0, j = s.length() - 1;
	while (i < j) {
	    if (s.charAt(i++) != s.charAt(j--))
		return false;
	}
	return true;
    }

    private static int minBase(String x) {
	int max = -1;
	for (int i = 0; i < x.length(); i++) {
	    int val = valueOf(x.charAt(i));
	    if (val > max)
		max = val;
	}
	return max + 1;
    }

    private static int baseCount(String x, int base) {
	int count = 0;
	while (!isPalindrome(x)) {
	    BigInteger a = new BigInteger(x, base);
	    BigInteger b = new BigInteger(new StringBuilder(x).reverse()
		    .toString(), base);
	    x = a.add(b).toString(base).toUpperCase();
	    count++;
	}
	return count;
    }

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	while (in.hasNext()) {
	    String num = in.next();
	    StringBuilder sb = new StringBuilder();
	    int index = minBase(num);
	    if (index < 2)
		index = 2;
	    if (!isPalindrome(num)) {
		for (int i = 15; i >= index; i--) {
		    if (i < 15)
			sb.append(" ");
		    sb.append(baseCount(num, i));
		}
	    } else {
		for (int i = 15; i >= index; i--) {
		    if (i < 15)
			sb.append(" ");
		    sb.append("0");
		}
	    }
	    for (int i = 2; i < index; i++) {
		sb.append(" ?");
	    }
	    System.out.println(sb);
	}

	in.close();
    }
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**