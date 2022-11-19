package LEETCODE;

public class _424 {
	private static class Solution {
		public int characterReplacement(String s, int k) {
			int[] count = new int[26];
			int maxCount = -1;
			int maxLength = -1;
			for (int start = 0, end = 0; end < s.length(); end++) {
				maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);

				while (end - start + 1 - maxCount > k) {
					count[s.charAt(start) - 'A']--;
					start++;
				}

				maxLength = Math.max(maxLength, end - start + 1);
			}

			return maxLength;
		}
	}
}
