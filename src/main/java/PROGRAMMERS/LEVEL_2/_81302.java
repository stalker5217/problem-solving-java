package PROGRAMMERS.LEVEL_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _81302 {
	private static class Solution {
		private static final int EMPTY = 0;
		private static final int PERSON = 1;
		private static final int PARTITION = 2;

		public static int[] solution(String[][] places) {
			class Position {
				public final int row;
				public final int col;

				public Position(int row, int col) {
					this.row = row;
					this.col = col;
				}
			}

			int[][] dir = {
				{-1, 0},
				{0, -1},
				{1, 0},
				{0, 1}
			};

			List<Integer> answer = new ArrayList<>();
			for (String[] place : places) {
				int[][] room = new int[5][5];
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if (place[i].charAt(j) == 'P') {
							room[i][j] = PERSON;
						} else if (place[i].charAt(j) == 'O') {
							room[i][j] = EMPTY;
						} else if (place[i].charAt(j) == 'X') {
							room[i][j] = PARTITION;
						}
					}
				}

				boolean good = true;
				for (int i = 0; i < 5; i++) {
					if (!good) {
						break;
					}
					for (int j = 0; j < 5; j++) {
						if (!good) {
							break;
						}
						if (room[i][j] == PERSON) {
							boolean[][] visited = new boolean[5][5];
							Queue<Position> q = new LinkedList<>();
							q.add(new Position(i, j));
							visited[i][j] = true;

							int distance = 0;
							while (!q.isEmpty() && distance < 2) {
								int size = q.size();
								while (size-- > 0) {
									Position cur = q.poll();
									for (int d = 0; d < 4; d++) {
										int nextRow = cur.row + dir[d][0];
										int nextCol = cur.col + dir[d][1];

										if (nextRow >= 0 && nextRow < 5
											&& nextCol >= 0 && nextCol < 5
											&& !visited[nextRow][nextCol]) {

											if (room[nextRow][nextCol] == PERSON) {
												good = false;
												break;
											}

											if (room[nextRow][nextCol] == EMPTY) {
												visited[nextRow][nextCol] = true;
												q.add(new Position(nextRow, nextCol));
											}
										}
									}

									if (!good) {
										break;
									}
								}

								distance++;
							}
						}
					}
				}

				answer.add(good ? 1 : 0);
			}

			return answer.stream().mapToInt(c -> c).toArray();
		}
	}
}
