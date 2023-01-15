package LEETCODE;

import java.util.Arrays;
import java.util.Comparator;

public class _435 {
	private static class Solution {
		public int eraseOverlapIntervals(int[][] intervals) {
			Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
			int delete = 0;
			int lastPos = -500001;
			for (int[] interval : intervals) {
				if (interval[0] < lastPos) {
					delete++;
				} else {
					lastPos = interval[1];
				}
			}

			return delete;
		}
	}
}
