package LEETCODE;

public class _152 {
	private static class Solution {
		public int maxProduct(int[] nums) {
			int max = nums[0];
			int min = nums[0];
			int answer = nums[0];

			for (int i = 1; i < nums.length; i++) {
				int tempMax = max;
				int tempMin = min;

				max = Math.max(nums[i], Math.max(tempMax * nums[i], tempMin * nums[i]));
				min = Math.min(nums[i], Math.min(tempMax * nums[i], tempMin * nums[i]));

				answer = Math.max(answer, max);
			}

			return answer;
		}
	}
}
