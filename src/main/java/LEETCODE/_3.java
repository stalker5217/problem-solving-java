package LEETCODE;

import java.util.HashSet;
import java.util.Set;

public class _3 {
	private static class Solution {
		public int lengthOfLongestSubstring(String s) {
			int answer = 0;
			int start = 0;
			int end = 0;
			Set<Character> charSet = new HashSet<>();
			while (end < s.length()) {
				if (charSet.contains(s.charAt(end))) {
					while(start < end && charSet.contains(s.charAt(end))) {
						charSet.remove(s.charAt(start));
						start++;
					}
				}

				charSet.add(s.charAt(end++));

				answer = Math.max(answer, end - start);
			}

			return answer;
		}
	}
}
