import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
		    String line = in.nextLine();
		    int count = line.replaceAll("[^a-zA-Z]+", " ").trim().split(" ").length;
		    System.out.println(count);
		}
		in.close();
    }
}