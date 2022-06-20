package PROGRAMMERS.LEVEL_2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _77485 {
	public static void main(String[] args) {

	}

	private static class Solution {
		public static int[] solution(int rows, int cols, int[][] queries) {

			int[][] arr = new int[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					arr[i][j] = cols * i + j + 1;
				}
			}

			List<Integer> answer = new ArrayList<>();
			for (int[] query : queries) {
				PriorityQueue<Integer> pq = new PriorityQueue<>();

				int sRow = query[0] - 1, sCol = query[1] - 1;
				int eRow = query[2] - 1, eCol = query[3] - 1;

				int prev = arr[sRow][sCol];
				for (int i = sCol + 1; i <= eCol; i++) {
					int temp = arr[sRow][i];
					arr[sRow][i] = prev;
					pq.add(prev);
					prev = temp;
				}

				for (int i = sRow + 1; i <= eRow; i++) {
					int temp = arr[i][eCol];
					arr[i][eCol] = prev;
					pq.add(prev);
					prev = temp;
				}

				for (int i = eCol - 1; i >= sCol; i--) {
					int temp = arr[eRow][i];
					arr[eRow][i] = prev;
					pq.add(prev);
					prev = temp;
				}

				for (int i = eRow - 1; i >= sRow; i--) {
					int temp = arr[i][sCol];
					arr[i][sCol] = prev;
					pq.add(prev);
					prev = temp;
				}

				answer.add(pq.poll());
			}

			return answer.stream().mapToInt(a->a).toArray();
		}
	}
}
