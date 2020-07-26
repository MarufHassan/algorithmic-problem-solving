import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	while (in.hasNextInt()) {
	    int fromBase = in.nextInt();
	    int toBase = in.nextInt();
	    String original = in.next();
	    long fromConverted = -1;
	    String toConverted = null;
	    try {
		fromConverted = Long.parseLong(original, fromBase);
		toConverted = Long.toUnsignedString(fromConverted, toBase)
			.toUpperCase();
		System.out.printf("%s base %d = %s base %d\n", original,
			fromBase, toConverted, toBase);
	    } catch (NumberFormatException e) {
		System.out.printf("%s is an illegal base %d number\n",
			original, fromBase);
	    }
	}

	in.close();
    }
}