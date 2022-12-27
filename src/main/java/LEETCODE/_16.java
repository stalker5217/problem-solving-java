package LEETCODE;

import java.util.Arrays;

public class _16 {
	private static class Solution {
		public int threeSumClosest(int[] nums, int target) {
			int answer = -1;
			int minDiff = Integer.MAX_VALUE;

			Arrays.sort(nums);
			for (int i = 0 ; i < nums.length - 2 ; i++) {
				int start = i + 1;
				int end = nums.length - 1;

				while (start < end) {
					int sum = nums[i] + nums[start] + nums[end];
					int diff = sum - target;

					if (diff > 0) {
						end--;
					} else {
						start++;
					}

					if (Math.abs(diff) < minDiff) {
						minDiff = Math.abs(diff);
						answer = sum;
					}
				}
			}

			return answer;
		}
	}
}
