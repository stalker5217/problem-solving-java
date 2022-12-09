package LEETCODE;

public class _1706 {
	private static class Solution {
		public int[] findBall(int[][] grid) {
			int m = grid.length;
			int n = grid[0].length;

			int[] answer = new int[n];
			for (int c = 0 ; c < n ; c++) {
				int current = c;
				for (int i = 0 ; i < m ; i++) {
					if (grid[i][current] == 1) {
						if (current == n - 1 || grid[i][current+1] == -1) {
							current = -1;
							break;
						} else {
							current++;
						}
					} else {
						if (current == 0 || grid[i][current-1] == 1) {
							current = -1;
							break;
						} else {
							current--;
						}
					}
				}

				answer[c] = current;
			}

			return answer;
		}
	}
}
