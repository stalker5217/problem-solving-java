package LEETCODE;

import java.util.HashMap;
import java.util.Map;

public class _169 {
	private static class Solution {
		public int majorityElement(int[] nums) {
			Map<Integer, Integer> numMap = new HashMap<>();

			for (int num : nums) {
				int count = numMap.getOrDefault(num, 0) + 1;

				if (count > nums.length / 2) {
					return num;
				}

				numMap.put(num, count);
			}

			return -1;
		}
	}
}
