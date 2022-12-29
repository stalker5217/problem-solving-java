package LEETCODE;

import java.util.HashMap;
import java.util.Map;

public class _76 {
	private static class Solution {
		public String minWindow(String s, String t) {
			if (s.length() < t.length()) {
				return "";
			}

			Map<Character, Integer> needMap = new HashMap<>();
			for (int i = 0 ; i < t.length() ; i++) {
				Integer count = needMap.getOrDefault(t.charAt(i), 0) + 1;
				needMap.put(t.charAt(i), count);
			}

			Map<Character, Integer> sMap = new HashMap<>();
			int need = t.length();
			int minLength = s.length() + 1;
			int subStart = 0;
			int subEnd = 0;

			int start = 0;
			int end = 0;
			while(end < s.length()) {
				Character endChar = s.charAt(end++);
				sMap.put(endChar, sMap.getOrDefault(endChar, 0) + 1);
				if (needMap.containsKey(endChar) && needMap.get(endChar) >= sMap.get(endChar)) {
					need--;
				}

				while (start < s.length() && start < end && needMap.getOrDefault(s.charAt(start), 0) < sMap.get(s.charAt(start))) {
					if (needMap.containsKey(s.charAt(start)) && needMap.get(s.charAt(start)) == sMap.get(s.charAt(start))) {
						need++;
					}

					sMap.put(s.charAt(start), sMap.get(s.charAt(start)) - 1);
					start++;
				}

				System.out.println(start + " " + end + "::" + need);
				if (need == 0 && end - start < minLength) {
					minLength = end - start;
					subStart = start;
					subEnd = end;
				}
			}

			String answer = "";
			if (minLength <= s.length()) {
				answer = s.substring(subStart, subEnd);
			}

			return answer;
		}
	}
}
