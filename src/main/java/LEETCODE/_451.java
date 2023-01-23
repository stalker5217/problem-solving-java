package LEETCODE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _451 {
	private static class Solution {
		public String frequencySort(String s) {
			Map<Character, Integer> freqMap = new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				int count = freqMap.getOrDefault(c, 0) + 1;
				freqMap.put(c, count);
			}

			List<Character> keyList = new ArrayList<>(freqMap.keySet());
			keyList.sort(Comparator.comparingInt(freqMap::get).reversed());

			StringBuilder sb = new StringBuilder();
			for(char key : keyList) {
				sb.append(String.valueOf(key).repeat(Math.max(0, freqMap.get(key))));
			}

			return sb.toString();
		}
	}
}
