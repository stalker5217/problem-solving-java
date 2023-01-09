package LEETCODE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _49 {
	private static class Solution {
		public List<List<String>> groupAnagrams(String[] strs) {
			Map<String, List<String>> anagramMap = new HashMap<>();

			for (String str : strs) {
				char[] chars = str.toCharArray();
				Arrays.sort(chars);
				String sortedStr = String.valueOf(chars);

				List<String> currentList = anagramMap.getOrDefault(sortedStr, new ArrayList<>());
				currentList.add(str);

				anagramMap.put(sortedStr, currentList);
			}

			return anagramMap.values()
				.stream()
				.toList();
		}
	}
}
