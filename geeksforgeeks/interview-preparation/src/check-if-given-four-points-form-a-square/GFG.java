import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    private static int distanceSquare(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;
        return dx * dx + dy * dy;
    }
    
    private static int checkSquare(int[] x, int[] y) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                int d = distanceSquare(x[i], y[i], x[j], y[j]);
                if (map.containsKey(d))
                    map.put(d, map.get(d) + 1);
                else
                    map.put(d, 1);
            }
        }
        return map.size() == 2 ? 1 : 0;
    }
    
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] x = new int[4];
		int[] y = new int[4];
		while (t-- > 0) {
		    for (int i = 0; i < 4; i++) {
		        x[i] = in.nextInt();
		        y[i] = in.nextInt();
		    }
		    System.out.println(checkSquare(x, y));
		}
		in.close();
	}
}