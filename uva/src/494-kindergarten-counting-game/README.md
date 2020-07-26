# Kindergarten counting game

## Solution

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
		    String line = in.nextLine();
		    int count = line.replaceAll("[^a-zA-Z]+", " ").trim().split(" ").length;
		    System.out.println(count);
		}
		in.close();
    }
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**