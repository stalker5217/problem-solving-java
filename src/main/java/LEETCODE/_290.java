package LEETCODE;

import java.util.HashMap;
import java.util.Map;

public class _290 {
	private static class Solution {
		public boolean wordPattern(String pattern, String s) {
			String[] splited = s.split(" ");
			if (pattern.length() != splited.length) {
				return false;
			}

			Map<Character, String> patternToWord = new HashMap<>();
			Map<String, Character> wordToPattern = new HashMap<>();
			for (int i = 0 ; i < pattern.length() ; i++) {
				Character c = pattern.charAt(i);
				String word = splited[i];
				if (!patternToWord.containsKey(c) && !wordToPattern.containsKey(word)) {
					patternToWord.put(c, word);
					wordToPattern.put(word, c);
				} else if (patternToWord.containsKey(c) && wordToPattern.containsKey(word)) {
					if (!patternToWord.get(c).equals(word) || !wordToPattern.get(word).equals(c)) {
						return false;
					}
				} else {
					return false;
				}
			}

			return true;
		}
	}
}
