import java.io.;
import java.util.;
import java.text.;
import java.math.;
import java.util.regex.;

public class Solution {
    public void solve() {
        Scanner in = new Scanner(System.in);
        PriorityQueueInteger pq = new PriorityQueue();
        int q = in.nextInt();
        while (q--  0) {
            int type = in.nextInt();
            if (type == 1) {
                int n = in.nextInt();
                pq.offer(n);
            } else if (type == 2) {
                int n = in.nextInt();
                pq.remove(n);
            } else {
                System.out.println(pq.peek());
            }
        }
        in.close();
    }

    public static void main(String[] args) {
       new Solution().solve();
    }
}

