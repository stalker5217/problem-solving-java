package PROGRAMMERS.LEVEL_2;

import java.util.ArrayList;
import java.util.List;

public class _86052 {
	class Solution {
		private final int[][] dirs = {
			{-1, 0},
			{0, -1},
			{1, 0},
			{0, 1}
		};

		public int[] solution(String[] _grid) {
			char[][] grid = new char[_grid.length][_grid[0].length()];
			for (int i = 0; i < _grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					grid[i][j] = _grid[i].charAt(j);
				}
			}

			List<Integer> answer = new ArrayList<>();
			boolean[][][] visited = new boolean[grid.length][grid[0].length][4];
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					for (int k = 0; k < 4; k++) {
						if (!visited[i][j][k]) {
							answer.add(dfs(i, j, k, grid, visited));
						}
					}
				}
			}

			return answer.stream().mapToInt(c -> c).sorted().toArray();
		}

		private int dfs(
			int row,
			int col,
			int dir,
			char[][] grid,
			boolean[][][] visited
		) {
			int length = 0;
			while (true) {
				length++;
				visited[row][col][dir] = true;

				if (grid[row][col] == 'L') {
					if (dir == 3) {
						dir = 0;
					} else {
						dir++;
					}
				} else if (grid[row][col] == 'R') {
					if (dir == 0) {
						dir = 3;
					} else {
						dir--;
					}
				}

				int nextRow = row + dirs[dir][0];
				if (nextRow >= grid.length) {
					nextRow = 0;
				} else if (nextRow < 0) {
					nextRow = grid.length - 1;
				}

				int nextCol = col + dirs[dir][1];
				if (nextCol >= grid[nextRow].length) {
					nextCol = 0;
				} else if (nextCol < 0) {
					nextCol = grid[nextRow].length - 1;
				}

				if (visited[nextRow][nextCol][dir]) {
					break;
				}

				row = nextRow;
				col = nextCol;
			}

			return length;
		}
	}
}
