package LEETCODE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15 {
	private static class Solution {
		public List<List<Integer>> threeSum(int[] nums) {
			Arrays.sort(nums);

			List<List<Integer>> answer = new ArrayList<>();
			for (int i = 0 ; i < nums.length ; i++) {
				if (i > 0 && nums[i - 1] == nums[i]) {
					continue;
				}

				int start = i + 1;
				int end = nums.length - 1;

				while (start < end) {
					int sum = nums[i] + nums[start] + nums[end];

					if (sum == 0) {
						answer.add(List.of(nums[i], nums[start], nums[end]));

						while (start < nums.length - 1 && nums[start] == nums[++start]);
						while (end > 0 && nums[end] == nums[--end]);
					} else if (sum > 0) {
						end--;
					} else {
						start++;
					}
				}
			}

			return answer;
		}
	}
}
