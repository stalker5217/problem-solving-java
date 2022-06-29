package PROGRAMMERS.LEVEL_2;

import java.util.ArrayList;
import java.util.List;

public class _87390 {
	class Solution {
		public int[] solution(int n, long left, long right) {
			List<Integer> answer = new ArrayList<>();
			for (long cur = left; cur <= right; cur++) {
				int i = (int)(cur / n);
				int j = (int)(cur % n);
				answer.add(Math.max(i, j) + 1);
			}

			return answer.stream().mapToInt(c -> c).toArray();
		}
	}
}
