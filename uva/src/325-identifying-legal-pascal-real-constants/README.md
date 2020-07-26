# Identifying legal pascal real constants

## Solution

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
		while (true) {
		    String line = in.nextLine().trim();
		    if (line.charAt(0) == '*') break;
		    if (line.matches("[-+]?\\d+(\\.\\d+([eE][-+]?\\d+)?|[eE][-+]?\\d+)"))
			System.out.println(line  + " is legal.");
		    else 
			System.out.println(line  + " is illegal.");
		}
		in.close();
    }
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**