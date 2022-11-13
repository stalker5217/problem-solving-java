package LEETCODE;

import java.util.LinkedList;
import java.util.Queue;

public class _733 {
	private static class Solution {
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

		private static class Position {
			public int x;
			public int y;

			public Position(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}

		public int[][] floodFill(int[][] image, int sr, int sc, int color) {
			boolean[][] visit = new boolean[image.length][image[0].length];

			Queue<Position> q = new LinkedList<>();
			q.add(new Position(sr, sc));
			visit[sr][sc] = true;
			while (!q.isEmpty()) {
				Position cur = q.poll();

				for (int i = 0; i < 4; i++) {
					int nextRow = cur.x + dirs[i].x;
					int nextCol = cur.y + dirs[i].y;

					if (nextRow >= 0
						&& nextRow < image.length
						&& nextCol >= 0
						&& nextCol < image[nextRow].length
						&& !visit[nextRow][nextCol]
						&& image[nextRow][nextCol] == image[cur.x][cur.y]
					) {
						visit[nextRow][nextCol] = true;
						q.add(new Position(nextRow, nextCol));
					}
				}

				image[cur.x][cur.y] = color;
			}

			return image;
		}
	}
}

