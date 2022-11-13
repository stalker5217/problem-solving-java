package LEETCODE;

public class _200 {
	private static class Solution {
		public int numIslands(char[][] grid) {
			int count = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					if (grid[i][j] == '1') {
						dfs(i, j, grid);
						count++;
					}
				}
			}

			return count;
		}

		private void dfs(int row, int col, final char[][] grid) {
			grid[row][col] = '2';
			for (int i = 0; i < 4; i++) {
				int nextRow = row + dirs[i].x;
				int nextCol = col + dirs[i].y;

				if (nextRow >= 0
					&& nextRow < grid.length
					&& nextCol >= 0
					&& nextCol < grid[nextRow].length
					&& grid[nextRow][nextCol] == '1'
				) {
					dfs(nextRow, nextCol, grid);
				}
			}
		}

		private static class Direction {
			public int x;
			public int y;

			public Direction(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}

		Direction[] dirs = {
			new Direction(-1, 0),
			new Direction(0, -1),
			new Direction(1, 0),
			new Direction(0, 1)
		};
	}
}
