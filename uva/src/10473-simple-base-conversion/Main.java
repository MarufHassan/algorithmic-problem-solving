import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	
	while (true) {
	    String line = in.nextLine();
	    if (line.charAt(0) == '-')
		break;
	    if (line.charAt(0) == '0' && line.charAt(1) == 'x') {
		line = line.substring(2, line.length());
		System.out.println(Integer.parseInt(line, 16));
	    } else {
		int intVal = Integer.parseInt(line);
		System.out.println("0x" + Integer.toHexString(intVal).toUpperCase());
	    }
	}

	in.close();
    }
}