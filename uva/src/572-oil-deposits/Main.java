import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (true) {
			int m = in.nextInt();
			in.nextInt();
			if (m == 0)
				break;

			String[] plots = new String[m];
			for (int i = 0; i < m; i++) {
				plots[i] = in.next();
			}

			DFS dfs = new DFS(plots);
			System.out.println(dfs.count());
		}

		in.close();
	}
}

class DFS {
	private static final int[] di = { 0, -1, 0, +1, -1, -1, +1, +1 };
	private static final int[] dj = { +1, 0, -1, 0, +1, -1, -1, +1 };

	private boolean marked[][];
	private int count;

	public DFS(String[] plots) {
		count = 0;

		int numOfRow = plots.length;
		int numOfCol = plots[0].length();
		marked = new boolean[numOfRow][numOfCol];

		for (int row = 0; row < numOfRow; row++) {
			for (int col = 0; col < numOfCol; col++) {
				if (!marked[row][col]) {
					if (plots[row].charAt(col) == '@') {
						dfs(plots, row, col);
						count++;
					}
				}
			}
		}
	}

	private void dfs(String[] plots, int row, int col) {
		marked[row][col] = true;
		for (int i = 0; i < 8; i++) {
			int newRow = row + di[i];
			int newCol = col + dj[i];
			if (isValid(plots, newRow, newCol)) {
				if (!marked[newRow][newCol]
						&& plots[newRow].charAt(newCol) == '@')
					dfs(plots, newRow, newCol);
			}
		}
	}

	private boolean isValid(String[] plots, int row, int col) {
		return row >= 0 && row < plots.length && col >= 0 && col < plots[0].length();
	}

	public int count() {
		return count;
	}
}
