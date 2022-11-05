package LEETCODE;

import java.util.Arrays;

public class _724 {
	private static class Solution {
		public int pivotIndex(int[] nums) {
			int leftSum = 0;
			int rightSum = Arrays.stream(nums).sum() - nums[0];

			int pivot = 0;
			while (pivot < nums.length) {
				if (leftSum == rightSum) {
					return pivot;
				}

				leftSum += nums[pivot++];

				if (pivot < nums.length) {
					rightSum -= nums[pivot];
				}
			}

			return -1;
		}
	}
}
