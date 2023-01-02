package LEETCODE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56 {
	class Solution {
		public int[][] merge(int[][] intervals) {
			Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

			List<int[]> answer = new ArrayList<>();
			for (int[] interval : intervals) {
				if (!answer.isEmpty() && interval[0] <= answer.get(answer.size() - 1)[1]) {
					int[] prev = answer.get(answer.size() - 1);
					prev[0] = Math.min(prev[0], interval[0]);
					prev[1] = Math.max(prev[1], interval[1]);
				} else {
					answer.add(interval);
				}
			}

			return answer.toArray(new int[0][0]);
		}
	}
}
