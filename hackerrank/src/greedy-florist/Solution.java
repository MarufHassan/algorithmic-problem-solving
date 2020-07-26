import java.io.;
import java.math.;
import java.security.;
import java.text.;
import java.util.;
import java.util.concurrent.;
import java.util.regex.;

public class Solution {
    static int getMinimumCost(int k, int[] original) {
        int n = original.length;
        int multiplier = 1;
        int price = 0;

        Arrays.sort(original);

        for (int i = n - 1; i = 0; i--) {
            price += (original[i]  multiplier);
            if ((n - i) % k == 0)
                multiplier++;
        }
        return price;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv(OUTPUT_PATH)));

        String[] nk = scanner.nextLine().split( );

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split( );
        scanner.skip((rn[nru2028u2029u0085]));

        for (int i = 0; i  n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
