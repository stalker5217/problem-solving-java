package LEETCODE;

public class _392 {
	private static class Solution {
		public boolean isSubsequence(String s, String t) {
			int sIndex = 0;
			for(int i = 0 ; i < t.length() && sIndex < s.length()  ; i++) {
				if (t.charAt(i) == s.charAt(sIndex)) {
					sIndex++;
				}
			}

			return sIndex == s.length();
		}
	}
}
