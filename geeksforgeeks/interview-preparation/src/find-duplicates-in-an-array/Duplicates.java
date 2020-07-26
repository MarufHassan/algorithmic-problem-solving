import java.util.Scanner;

class Duplicates{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			GfG g = new GfG();
			g.printDuplicates(a,n);
			System.out.println();
		}
	}
}
class GfG {
    public void printDuplicates(int arr[], int n) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            int idx = arr[i] % n;
            arr[idx] += n;
            if (arr[idx] / n == 2) {
                System.out.print(idx + " ");
                flag = true;
            }
        }
        if (!flag)
            System.out.print(-1);
    }
}