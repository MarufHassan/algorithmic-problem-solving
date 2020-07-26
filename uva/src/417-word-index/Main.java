import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	private static Map<String, Integer> generate() {
		Map<String, Integer> maps;
		maps = new HashMap<String, Integer>();
		Queue<String> q = new LinkedList<String>();
		int count = 0;
		for (char c = 'a'; c <= 'z'; c++) {
			q.add(String.valueOf(c));
		}
		while (!q.isEmpty()) {
			String s = q.poll();
			maps.put(s, ++count);
			if (s.length() >= 5)	continue;
			char c = (char) (s.charAt(s.length() - 1) + 1);
			for (; c <= 'z'; c++) {
				q.add(s + c);
			}
		}
		return maps;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Map<String, Integer> maps = generate();
		while (in.hasNextLine()) {
			String line = in.nextLine();
			Integer value = maps.get(line); 
			if (value == null)
				System.out.println(0);
			else
				System.out.println(value);
		}
		in.close();
	}
}
