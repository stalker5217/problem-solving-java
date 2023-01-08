package LEETCODE;

public class _59 {
	private static class Solution {
		private static final Direction[] dirs = {
			new Direction(0, 1),
			new Direction(1, 0),
			new Direction(0, -1),
			new Direction(-1, 0)
		};

		public int[][] generateMatrix(int n) {
			int[][] matrix = new int[n][n];
			for (int i = 1, x = 0, y = 0, dir = 0; i <= n * n; i++) {
				matrix[x][y] = i;

				int nextX = x + dirs[dir].x;
				int nextY = y + dirs[dir].y;
				if (nextX >= 0 && nextX < n
					&& nextY >= 0 && nextY < n
					&& matrix[nextX][nextY] == 0) {
					x = nextX;
					y = nextY;
				} else {
					dir = (dir + 1) % 4;
					x = x + dirs[dir].x;
					y = y + dirs[dir].y;
				}
			}

			return matrix;
		}

		private static class Direction {
			public int x;
			public int y;

			public Direction(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
	}
}
