# Maze exploration

## Solution

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());

		for (int t = 0; t < n; t++) {
			List<StringBuilder> maps = new ArrayList<StringBuilder>();

			String line;
			while (true) {
				line = in.nextLine();
				if (line.contains("_"))
					break;
				maps.add(new StringBuilder(line));
			}

			int startRow = -1, startCol = -1;
			for (int i = 0; i < maps.size(); i++) {
				for (int j = 0; j < maps.get(i).length(); j++) {
					if (maps.get(i).charAt(j) == '*') {
						startRow = i;
						startCol = j;
						break;
					}
				}
			}
			new DFS(maps, startRow, startCol);
			for (StringBuilder string : maps) {
				System.out.println(string);
			}
			System.out.println(line);
		}
		in.close();
	}
}

class DFS {
	private static final int[] di = { 0, -1, 0, +1 };
	private static final int[] dj = { +1, 0, -1, 0 };

	private boolean[][] marked;

	public DFS(List<StringBuilder> maps, int row, int col) {

		marked = new boolean[35][85];
		dfs(maps, row, col);
	}

	private void dfs(List<StringBuilder> maps, int row, int col) {
		marked[row][col] = true;
		maps.get(row).setCharAt(col, '#');

		for (int i = 0; i < 4; i++) {
			int newRow = row + di[i];
			int newCol = col + dj[i];

			if (isValid(maps, newRow, newCol)) {
				if (!marked[newRow][newCol]
						&& maps.get(newRow).charAt(newCol) == ' ') {
					dfs(maps, newRow, newCol);
				}
			}
		}
	}

	private boolean isValid(List<StringBuilder> maps, int row, int col) {
		return row >= 0 && row < maps.size() && col >= 0 && col < 85;
	}
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**