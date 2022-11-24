package LEETCODE;

import java.util.Arrays;

public class _14 {
	private static class Solution {
		public String longestCommonPrefix(String[] strs) {
			int minLength = Arrays.stream(strs)
				.mapToInt(String::length)
				.min()
				.getAsInt();

			StringBuilder answer = new StringBuilder();
			for (int i = 0; i < minLength; i++) {
				boolean match = true;
				char base = strs[0].charAt(i);

				for (String str : strs) {
					if (str.charAt(i) != base) {
						match = false;
						break;
					}
				}

				if (match) {
					answer.append(base);
				} else {
					break;
				}
			}

			return answer.toString();
		}
	}
}
