package LEETCODE;

import java.util.ArrayList;
import java.util.List;

public class _438 {
	private static class Solution {
		public List<Integer> findAnagrams(String s, String p) {
			List<Integer> answer = new ArrayList<>();
			if (s.length() < p.length()) {
				return answer;
			}

			int[] windows = new int[26];
			int[] target = new int[26];

			for (int i = 0; i < p.length(); i++) {
				windows[s.charAt(i) - 'a']++;
				target[p.charAt(i) - 'a']++;
			}

			int start = 0;
			while (true){
				boolean isAnagram = true;
				for(int i = 0 ; i < 26 ; i++) {
					if (windows[i] != target[i]) {
						isAnagram = false;
						break;
					}
				}

				if (isAnagram) {
					answer.add(start);
				}

				int end = start + p.length();
				if (end >= s.length()) {
					break;
				}

				windows[s.charAt(start) - 'a']--;
				windows[s.charAt(end) - 'a']++;
				start++;
			}

			return answer;
		}
	}
}
