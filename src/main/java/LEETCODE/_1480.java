package LEETCODE;

public class _1480 {
	private static class Solution {
		public int[] runningSum(int[] nums) {
			int[] accumulate = new int[nums.length];
			accumulate[0] = nums[0];
			for(int i = 1 ; i < nums.length ; i++) {
				accumulate[i] = accumulate[i - 1] + nums[i];
			}

			return accumulate;
		}
	}
}
