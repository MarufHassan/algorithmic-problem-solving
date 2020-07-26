# Common permutation

## Solution

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String A, B;

		while (in.hasNextLine()) {
		    A = in.nextLine();
		    B = in.nextLine();

		    int[] countA = new int[26];
		    int[] countB = new int[26];

		    for (int i = 0; i < A.length(); i++) {
				countA[A.charAt(i) - 'a']++;
		    }
		    for (int i = 0; i < B.length(); i++) {
				countB[B.charAt(i) - 'a']++;
		    }

		    for (int i = 0; i < 26; i++) {
				for (int j = Math.min(countA[i], countB[i]); j >= 1; j--) {
				    System.out.print((char) ('a' + i));
				}
		    }
		    System.out.println();
		}
		in.close();
    }
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**