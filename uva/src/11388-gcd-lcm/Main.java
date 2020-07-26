import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int tests = in.nextInt();
	while (tests-- > 0) {
	    int G = in.nextInt();
	    int L = in.nextInt();
	    if (L % G == 0) 
		System.out.println(G + " " + L);
	    else
		System.out.println("-1");
	}
	in.close();
    }
}
