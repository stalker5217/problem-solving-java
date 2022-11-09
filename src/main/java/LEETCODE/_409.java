package LEETCODE;

import java.util.HashMap;
import java.util.Map;

public class _409 {
	private static class Solution {
		public int longestPalindrome(String s) {
			int answer = 0;
			Map<Character, Integer> charMap = new HashMap<>();
			for(int i = 0 ; i < s.length() ; i++) {
				if (charMap.containsKey(s.charAt(i))) {
					charMap.remove(s.charAt(i));
					answer += 2;
				} else {
					charMap.put(s.charAt(i), 1);
				}
			}

			if (charMap.size() > 0) {
				answer++;
			}

			return answer;
		}
	}
}
