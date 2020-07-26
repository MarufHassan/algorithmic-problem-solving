import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Integer> findDivisors(int n) {
	List<Integer> divs = new ArrayList<Integer>();
	for (int i = 1; i * i <= n; i++) {
	    if (n % i == 0) {
		divs.add(i);
		if (i * i < n)
		    divs.add(n / i);
	    }
	}
	return divs;
    }

    public static int findGCD(int a, int b) {
	if (b == 0)
	    return a;
	return findGCD(b, a % b);
    }

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	while (true) {
	    int n = in.nextInt();
	    if (n == 0)
		break;
	    List<Integer> divs = findDivisors(n);
	    int count = 0;
	    for (int i = 0; i < divs.size(); i++) {
		for (int j = i; j < divs.size(); j++) {
		    if (findGCD(divs.get(i), divs.get(j)) == 1) {
			count++;
		    }
		}
	    }
	    System.out.println(n + " " + count);
	}
	in.close();
    }
}
