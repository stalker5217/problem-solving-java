package LEETCODE;

import java.util.Arrays;

public class _416 {
	private static class Solution {
		public boolean canPartition(int[] nums) {
			int sum = Arrays.stream(nums).sum();
			if (sum % 2 == 1) {
				return false;
			}

			int[][] cache = new int[sum / 2 + 1][nums.length];
			for (int[] c : cache) {
				Arrays.fill(c, -1);
			}

			return helper(sum / 2, 0, nums, cache) > 0;
		}

		private int helper(int remain, int index, int[] nums, int[][] cache) {
			if (remain == 0) {
				return 1;
			}

			if (index == nums.length) {
				return 0;
			}

			if (cache[remain][index] != -1) {
				return cache[remain][index];
			}

			int result = 0;
			result += helper(remain, index + 1, nums, cache);
			if (result == 0 && remain >= nums[index]) {
				result += helper(remain - nums[index], index + 1, nums, cache);
			}

			cache[remain][index] = result;
			return cache[remain][index];
		}
	}
}
