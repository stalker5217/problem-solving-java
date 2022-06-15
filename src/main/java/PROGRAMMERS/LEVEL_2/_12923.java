package PROGRAMMERS.LEVEL_2;

import java.util.Arrays;

public class _12923 {
	public static void main(String[] args) {
		for (int cur : Solution.solution(1, 10)) {
			System.out.print(cur + " ");
		}
	}

	private static class Solution {
		public static int[] solution(long begin, long end) {
			int size = (int)(end - begin) + 1;
			long[] answer = new long[size];

			for (int i = 0; i < size; i++) {
				answer[i] = 1;
				for (long j = 2L; j * j <= begin + i; j++) {
					if ((begin + i) % j == 0 && (begin + i) / j <= 10000000L) {
						answer[i] = (begin + i) / j;
						break;
					}
				}
			}

			if (begin == 1)
				answer[0] = 0;

			return Arrays
				.stream(answer)
				.mapToInt(c -> (int)c)
				.toArray();
		}
	}
}
