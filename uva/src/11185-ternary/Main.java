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