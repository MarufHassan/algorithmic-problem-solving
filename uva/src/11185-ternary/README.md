# Ternary

## Solution

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	while (true) {
	    int n = in.nextInt();
	    if (n < 0) break;
	    System.out.println(Integer.toUnsignedString(n, 3));
	}
	in.close();
    }
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**