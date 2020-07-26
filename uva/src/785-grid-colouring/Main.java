import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNextLine()) {
			List<StringBuilder> grid = new ArrayList<StringBuilder>();
			String line;
			while(true) {
				line = in.nextLine();
				if (line.contains("_"))	break;
				grid.add(new StringBuilder(line));
			}
			
			new DFS(grid);
			for (StringBuilder string : grid) {
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

	public DFS(List<StringBuilder> grid) {
		marked = new boolean[35][85];
		
		char contour = contourChar(grid);
		for (int row = 0; row < grid.size(); row++) {
			for (int col = 0; col < grid.get(row).length(); col++) {
				char c = grid.get(row).charAt(col);
				if (!marked[row][col] && c != ' ' && c != contour) {
					dfs(grid, row, col, c);
				}
			}
		}
	}
	
	private char contourChar(List<StringBuilder> grid) {
		for (int row = 0; row < grid.size(); row++) {
			for (int col = 0; col < grid.get(row).length(); col++) {
				if (grid.get(row).charAt(col) != ' ') {
					return grid.get(row).charAt(col);
				}
			}
		}
		return ' ';
	}

	private void dfs(List<StringBuilder> grid, int row, int col, char marker) {
		marked[row][col] = true;
		grid.get(row).setCharAt(col, marker);

		for (int i = 0; i < 4; i++) {
			int newRow = row + di[i];
			int newCol = col + dj[i];

			if (isValid(grid, newRow, newCol)) {
				if (!marked[newRow][newCol]
						&& grid.get(newRow).charAt(newCol) == ' ') {
					dfs(grid, newRow, newCol, marker);
				}
			}
		}
	}

	private boolean isValid(List<StringBuilder> grid, int row, int col) {
		return row >= 0 && row < grid.size() && col >= 0 && col < grid.get(row).length();
	}
}