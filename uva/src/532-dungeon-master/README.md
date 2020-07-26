# Dungeon master

## Solution

```java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			int L = in.nextInt();
			int R = in.nextInt();
			int C = in.nextInt();
			if (L == 0 && R == 0 && C == 0)
				break;
			in.nextLine();
			String cells[][] = new String[L][R];
			for (int z = 0; z < L; z++) {
				for (int x = 0; x < R; x++) {
					cells[z][x] = in.nextLine();
				}
				in.nextLine();
			}
			int startX = 0, startY = 0, startZ = 0;
			for (int z = 0; z < L; z++) {
				for (int x = 0; x < R; x++) {
					for (int y = 0; y < C; y++) {
						if (cells[z][x].charAt(y) == 'S') {
							startX = x;
							startY = y;
							startZ = z;
							break;
						}
					}
				}
			}
			BFS bfs = new BFS(cells, startX, startY, startZ);
			if (bfs.isTrapped())
				System.out.println("Trapped!");
			else
				System.out.printf("Escaped in %d minute(s).\n", bfs.cost());
		}
		in.close();
	}
}

class Node {
	int x;
	int y;
	int z;
	int cost;

	public Node(int x, int y, int z, int cost) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.cost = cost;
	}
}

class BFS {
	private static int[] di = { -1, 1, 0, 0, 0, 0 };
	private static int[] dj = { 0, 0, -1, 1, 0, 0 };
	private static int[] dk = { 0, 0, 0, 0, -1, 1 };

	private boolean[][][] marked;
	private Node fin;

	public BFS(String[][] cells, int x, int y, int z) {
		marked = new boolean[30][30][30];
		fin = bfs(cells, x, y, z);
	}

	private Node bfs(String[][] cells, int x, int y, int z) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(x, y, z, 0));
		marked[z][x][y] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (cells[node.z][node.x].charAt(node.y) == 'E') {
				return node;
			}

			for (int i = 0; i < 6; i++) {
				int newX = node.x + di[i];
				int newY = node.y + dj[i];
				int newZ = node.z + dk[i];
				if (isValid(cells, newX, newY, newZ)) {
					if (!marked[newZ][newX][newY]
							&& (cells[newZ][newX].charAt(newY) == '.' || cells[newZ][newX]
									.charAt(newY) == 'E')) {
						marked[newZ][newX][newY] = true;
						q.add(new Node(newX, newY, newZ, node.cost + 1));
					}
				}
			}
		}
		return null;
	}

	private boolean isValid(String[][] cells, int x, int y, int z) {
		return x >= 0 && x < cells[0].length && y >= 0
				&& y < cells[0][0].length() && z >= 0 && z < cells.length;
	}

	public int cost() {
		return fin.cost;
	}

	public boolean isTrapped() {
		return fin == null;
	}
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**