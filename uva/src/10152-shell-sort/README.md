# 10152 - ShellSort

## Solution

```java
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	String[] initial = new String[200], sorted = new String[200];

	int t = in.nextInt();
	while (t-- > 0) {
		int n = in.nextInt();
		in.nextLine();
		for (int i = 0; i < n; i++) initial[i] = in.nextLine();
		for (int i = 0; i < n; i++) sorted[i] = in.nextLine();

		int ptr1 = n - 1, ptr2 = n - 1;
		while (ptr1 >= 0) {
			if (initial[ptr1].equals(sorted[ptr2])) {
				ptr1--; ptr2--;
			} else {
				ptr1--;
			}
		}
		while (ptr2 >= 0) {
			out.println(sorted[ptr2]);
			ptr2--;
		}
		out.println();
	}

	in.close();
	out.close();
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**