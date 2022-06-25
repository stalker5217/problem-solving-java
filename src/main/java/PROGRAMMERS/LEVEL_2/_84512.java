package PROGRAMMERS.LEVEL_2;

import java.util.HashMap;
import java.util.Map;

public class _84512 {
	private static class Solution {
		private static final String[] vowels = {"A", "E", "I" , "O", "U"};
		private static final Map<String, Integer> orderMap = new HashMap<>();
		private static int order = 0;

		public int solution(String word) {
			getOrder("");
			return orderMap.get(word);
		}

		private static void getOrder(String cur) {
			orderMap.put(cur, order);

			if (cur.length() == 5) {
				return;
			}

			for(int i = 0 ; i < 5 ; i++) {
				order++;
				getOrder(cur + vowels[i]);
			}
		}
	}
}
