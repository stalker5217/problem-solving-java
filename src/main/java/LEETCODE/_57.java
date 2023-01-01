package LEETCODE;

import java.util.ArrayList;
import java.util.List;

public class _57 {
	private static class Solution {
		public int[][] insert(int[][] intervals, int[] newInterval) {
			List<int[]> answer = new ArrayList<>();
			int i = 0;

			while (i < intervals.length && intervals[i][1] < newInterval[0]) {
				answer.add(intervals[i++]);
			}

			while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
				newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
				newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
				i++;
			}
			answer.add(newInterval);

			while (i < intervals.length) {
				answer.add(intervals[i++]);
			}

			return answer.toArray(new int[0][0]);
		}
	}
}
