package LEETCODE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _763 {
	private static class Solution {
		public List<Integer> partitionLabels(String s) {
			Map<Character, Integer> lastIndex = new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				Character c = s.charAt(i);
				lastIndex.put(c, i);
			}

			List<Integer> answer = new ArrayList<>();
			int fromIndex = 0;
			int toIndex = -1;
			for (int i = 0; i < s.length(); i++) {
				toIndex = Math.max(toIndex, lastIndex.get(s.charAt(i)));
				if (toIndex == i) {
					answer.add(toIndex - fromIndex + 1);
					fromIndex = toIndex + 1;
				}
			}

			return answer;
		}
	}
}
