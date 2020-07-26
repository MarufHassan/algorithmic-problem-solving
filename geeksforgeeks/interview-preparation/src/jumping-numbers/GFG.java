import java.util.*;
import java.io.*;

class GFG {
    
    private static void find(long d, long limit, List<Long> numbers) {
        Queue<Long> q = new LinkedList<>();
        q.add(d);
        while (!q.isEmpty()) {
            long pop = q.remove();
            if (pop <= limit) {
                numbers.add(pop);
                long ld = pop % 10;
                if (ld > 0)
                    q.add((pop * 10) + (ld - 1));
                if (ld < 9)
                    q.add((pop * 10) + (ld + 1));
            }
        }
    }
    
    private static List<Long> find(long n) {
        List<Long> numbers = new ArrayList<>();
        numbers.add(0L);
        for (long d = 1; d <= 9 && d <= n; d++) {
            find(d, n, numbers);
        }
        return numbers;
    }
    
    public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
	    PrintWriter out = new PrintWriter(System.out);
	    int t = in.nextInt();
	    while (t-- > 0) {
	        long n = in.nextLong();
	        List<Long> result = find(n);
	        Collections.sort(result);
	        for (long i : result)
	            out.print(i + " ");
	        out.println();
	    }
	    out.close();
	    in.close();
	}
}