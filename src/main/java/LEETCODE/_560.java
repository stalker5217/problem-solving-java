package LEETCODE;

import java.util.HashMap;
import java.util.Map;

public class _560 {
	private static class Solution {
		public int subarraySum(int[] nums, int k) {
			int answer = 0;
			int sum = 0;
			Map<Integer, Integer> preSum = new HashMap<>();
			preSum.put(0, 1);
			for (int num : nums) {
				sum += num;
				if (preSum.containsKey(sum - k)) {
					answer += preSum.get(sum - k);
				}

				int count = preSum.getOrDefault(sum, 0) + 1;
				preSum.put(sum, count);
			}

			return answer;
		}
	}
}
