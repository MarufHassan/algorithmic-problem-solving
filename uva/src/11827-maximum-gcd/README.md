# Maximum gcd

## Solution

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static int findGCD(int a, int b) {
	if (b == 0)
	    return a;
	return findGCD(b, a % b);
    }

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int tests = in.nextInt();
	in.nextLine();
	while (tests-- > 0) {
	    StringTokenizer tokens = new StringTokenizer(in.nextLine());
	    List<Integer> list = new ArrayList<>();
	    while (tokens.hasMoreTokens()) {
		list.add(Integer.parseInt(tokens.nextToken()));
	    }
	    int max = Integer.MIN_VALUE;
	    for (int i = 0; i < list.size(); i++) {
		for (int j = i + 1; j < list.size(); j++) {
		    int gcd = findGCD(list.get(i), list.get(j));
		    if (gcd > max)
			max = gcd;
		}
	    }
	    System.out.println(max);
	}
	in.close();
    }
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**