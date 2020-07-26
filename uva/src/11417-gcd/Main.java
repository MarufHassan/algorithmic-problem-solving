import java.util.Scanner;

public class Main {
    public static int findGCD(int a, int b) {
	if (b == 0)
	    return a;
	return findGCD(b, a % b);
    }

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	while (true) {
	    int n = in.nextInt();
	    if (n == 0) break;
	    int G = 0;
	    for (int i = 1; i < n; i++) {
		for (int j = i + 1; j <= n; j++) {
		    G += findGCD(i, j);
		}
	    }
	    System.out.println(G);
	}
	in.close();
    }
}
