package LEETCODE;

public class _75 {
	private static class Solution {
		public void sortColors(int[] nums) {
			int[] cnt = new int[3];
			for (int num : nums) {
				cnt[num]++;
			}

			int k = 0;
			for (int i = 0 ; i < cnt.length ; i++) {
				for (int j = 0 ; j < cnt[i] ; j++) {
					nums[k++] = i;
				}
			}
		}
	}
}
