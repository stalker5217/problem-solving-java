package PROGRAMMERS.LEVEL_2;

public class _86971 {
	class Solution {
		public int solution(int n, int[][] wires) {
			int answer = 100;

			boolean[][] connected = new boolean[n + 1][n + 1];
			for (int[] wire : wires) {
				connected[wire[0]][wire[1]] = true;
				connected[wire[1]][wire[0]] = true;
			}

			for (int[] wire : wires) {
				connected[wire[0]][wire[1]] = false;
				connected[wire[1]][wire[0]] = false;

				boolean[] visited = new boolean[n + 1];
				dfs(1, connected, visited, n);

				int a = 0;
				int b = 0;
				for (int i = 1 ; i <= n ; i++) {
					if (visited[i])
						a++;
					else
						b++;
				}

				answer = Math.min(answer, Math.abs(a - b));

				connected[wire[0]][wire[1]] = true;
				connected[wire[1]][wire[0]] = true;
			}

			return answer;
		}

		private void dfs(int pos, boolean[][] connected, boolean[] visited, final int n) {
			visited[pos] = true;
			for (int i = 1; i <= n; i++) {
				if (connected[pos][i] && !visited[i]) {
					dfs(i, connected, visited, n);
				}
			}
		}
	}
}
