package LEETCODE;

import java.util.ArrayList;
import java.util.List;

public class _54 {
	private static class Solution {
		public List<Integer> spiralOrder(int[][] matrix) {
			Direction[] dirs = {
				new Direction(0, 1),
				new Direction(1, 0),
				new Direction(0, -1),
				new Direction(-1, 0)
			};

			List<Integer> answer = new ArrayList<>();

			int height = matrix.length;
			int width = matrix[0].length;
			int index = 0;
			int count = width * height;
			int x = 0;
			int y = 0;
			boolean[][] visit = new boolean[height][width];

			while (count-- > 0) {
				visit[x][y] = true;

				answer.add(matrix[x][y]);

				int nextX = x + dirs[index].x;
				int nextY = y + dirs[index].y;

				if (nextX < 0 || nextX >= height || nextY < 0 || nextY >= width || visit[nextX][nextY]) {
					nextX -= dirs[index].x;
					nextY -= dirs[index].y;

					index = (index + 1) % 4;

					nextX += dirs[index].x;
					nextY += dirs[index].y;
				}

				x = nextX;
				y = nextY;
			}

			return answer;
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
