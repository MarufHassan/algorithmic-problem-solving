import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int tc = in.nextInt();
	while (tc-- > 0) {
	    int num1 = Integer.parseInt(in.next(), 16);
	    char operator = in.next().charAt(0);
	    int num2 = Integer.parseInt(in.next(), 16);
	    int result = -1;
	    if (operator == '+') {
		result = num1 + num2;
	    } else {
		result = num1 - num2;
	    }
	    String s1 = Integer.toBinaryString(num1);
	    String s2 = Integer.toBinaryString(num2);
	    StringBuilder zero1 = new StringBuilder();
	    StringBuilder zero2 = new StringBuilder();
	    
	    for (int i = 1; i <= 13 - s1.length(); i++) {
		zero1.append('0');
	    }
	    for (int i = 1; i <= 13 - s2.length(); i++) {
		zero2.append('0');
	    }

	    System.out.println(zero1 + s1 + " " + operator + " " + zero2 + s2
		    + " = " + result);
	}

	in.close();
    }
}