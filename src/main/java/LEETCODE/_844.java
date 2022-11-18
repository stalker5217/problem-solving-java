package LEETCODE;

public class _844 {
	private static class Solution {
		public boolean backspaceCompare(String s, String t) {
			String sr = getResult(s);
			String tr = getResult(t);

			return sr.equals(tr);
		}

		private String getResult(String s) {
			String sr = "";

			int blankCount = 0;
			for(int  i = s.length() - 1 ; i >= 0 ; i--) {
				if (s.charAt(i) == '#') {
					blankCount++;
				} else {
					if (blankCount > 0) {
						blankCount--;
					} else {
						sr = s.charAt(i) + sr;
					}
				}
			}

			return sr;
		}
	}
}
