package LEETCODE;

import java.util.HashMap;
import java.util.Map;

public class _2131 {
	private static class Solution {
		public int longestPalindrome(String[] words) {
			boolean existsMiddle = false;
			int pairCnt = 0;

			Map<String, Integer> candidate = new HashMap<>();
			for (int i = 0; i < words.length; i++) {
				String base = words[i];
				String reversed = new StringBuilder(base).reverse().toString();

				if (candidate.getOrDefault(reversed, 0) > 0) {
					candidate.put(reversed, candidate.get(reversed) - 1);
					pairCnt += 2;
				} else {
					candidate.put(base, candidate.getOrDefault(base, 0) + 1);
				}
			}

			for (String key : candidate.keySet()) {
				if (candidate.get(key) > 0 && key.charAt(0) == key.charAt(1)) {
					existsMiddle = true;
					break;
				}
			}

			return 2 * pairCnt + (existsMiddle ? 2 : 0);
		}
	}
}
