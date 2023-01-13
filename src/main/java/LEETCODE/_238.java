package LEETCODE;

import java.util.Arrays;

public class _238 {
	private static class Solution {
		public int[] productExceptSelf(int[] nums) {
			int n = nums.length;
			int[] answer = new int[n];
			Arrays.fill(answer, 1);

			int prefixProduct = 1;
			int suffixProduct = 1;
			for (int i = 1 ; i < n ; i++) {
				prefixProduct *= nums[i - 1];
				suffixProduct *= nums[n - i];

				answer[i] *= prefixProduct;
				answer[n - 1 - i] *= suffixProduct;
			}

			return answer;
		}
	}
}
