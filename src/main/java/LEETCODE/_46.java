package LEETCODE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _46 {
	private static class Solution {
		public List<List<Integer>> permute(int[] nums) {
			List<List<Integer>> answer = new ArrayList<>();
			helper(nums, 0, answer);

			return answer;
		}

		private void helper(int[] nums, int start, final List<List<Integer>> answer) {
			if (start == nums.length) {
				answer.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
				return;
			}

			for (int i = start ; i < nums.length ; i++) {
				swap(nums, start, i);
				helper(nums, start + 1, answer);
				swap(nums, start, i);
			}
		}

		private void swap(final int[] nums, int a, int b) {
			int temp = nums[a];
			nums[a] = nums[b];
			nums[b] = temp;
		}
	}
}
