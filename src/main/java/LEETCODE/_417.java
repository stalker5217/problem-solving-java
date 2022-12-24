package LEETCODE;

import java.util.ArrayList;
import java.util.List;

public class _417 {
	private static class Solution {
		private Direction[] dirs = {
			new Direction(-1, 0),
			new Direction(0, -1),
			new Direction(1, 0),
			new Direction(0, 1)
		};

		public List<List<Integer>> pacificAtlantic(int[][] heights) {
			int n = heights.length;
			int m = heights[0].length;

			boolean[][] pacific = new boolean[n][m];
			boolean[][] atlantic = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				helper(i, 0, pacific, heights);
				helper(i, m - 1, atlantic, heights);
			}

			for (int i = 0; i < m; i++) {
				helper(0, i, pacific, heights);
				helper(n -1 , i, atlantic, heights);
			}

			List<List<Integer>> answer = new ArrayList<>();
			for (int i = 0 ; i < n ; i++) {
				for (int j = 0 ; j < m ; j++) {
					if (pacific[i][j] && atlantic[i][j]) {
						answer.add(List.of(i, j));
					}
				}
			}

			return answer;
		}

		private void helper(int row, int col, final boolean[][] visit, final int[][] heights) {
			if (visit[row][col]) {
				return;
			}

			visit[row][col] = true;

			for (int i = 0; i < dirs.length; i++) {
				int nextRow = row + dirs[i].row;
				int nextCol = col + dirs[i].col;

				if (nextRow >= 0
					&& nextRow < heights.length
					&& nextCol >= 0
					&& nextCol < heights[nextRow].length
					&& heights[row][col] <= heights[nextRow][nextCol]
				) {
					helper(nextRow, nextCol, visit, heights);
				}
			}
		}

		private static class Direction {
			public int row;
			public int col;

			public Direction(int row, int col) {
				this.row = row;
				this.col = col;
			}
		}
	}
}
