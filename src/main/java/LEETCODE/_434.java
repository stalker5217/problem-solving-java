package LEETCODE;

public class _434 {
	private static class Solution {
		public int countSegments(String s) {
			int result = 0;
			boolean isBlankPrevious = true;
			for (int i = 0; i < s.length(); i++) {
				if (isBlankPrevious && s.charAt(i) != ' ') {
					result++;
				}

				isBlankPrevious = s.charAt(i) == ' ';
			}

			return result;
		}
	}
}
