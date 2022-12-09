package LEETCODE;

import java.util.LinkedList;
import java.util.Queue;

public class _994 {
	private static class Solution {
		public int orangesRotting(int[][] grid) {
			Queue<Position> q = new LinkedList<>();
			// Check rotten orange
			for (int i = 0 ; i < grid.length ; i++) {
				for (int j = 0 ; j < grid[i].length ; j++) {
					if (grid[i][j] == 2) {
						q.add(new Position(i, j));
					}
				}
			}

			Position[] dirs = {
				new Position(1, 0),
				new Position(-1, 0),
				new Position(0, 1),
				new Position(0, -1)
			};

			// Simulation
			int day = 0;
			while (!q.isEmpty()) {
				int size = q.size();
				while (size-- > 0) {
					Position cur = q.poll();

					for (int i = 0 ; i < 4 ; i++) {
						int nextRow = cur.row + dirs[i].row;
						int nextCol = cur.col + dirs[i].col;

						if (nextRow >= 0 && nextRow < grid.length
							&& nextCol >= 0 && nextCol < grid[nextRow].length
							&& grid[nextRow][nextCol] == 1
						) {
							grid[nextRow][nextCol] = 2;
							q.add(new Position(nextRow, nextCol));
						}
					}
				}

				if (q.size() > 0) {
					day++;
				}
			}

			// Check fresh orange exists
			boolean allRotten = true;
			for (int i = 0 ; i < grid.length ; i++) {
				for (int j = 0 ; j < grid[i].length ; j++) {
					if (grid[i][j] == 1) {
						allRotten = false;
						break;
					}
				}
			}

			return allRotten ? day : -1;
		}

		private static class Position {
			public int row;
			public int col;

			public Position(int row, int col) {
				this.row = row;
				this.col = col;
			}
		}
	}
}
