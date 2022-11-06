package LEETCODE;

import java.util.HashMap;
import java.util.Map;

public class _205 {
	private static class Solution {
		public boolean isIsomorphic(String s, String t) {
			Map<Character, Integer> sMap = new HashMap<>();
			Map<Character, Integer> tMap = new HashMap<>();

			int length = s.length();
			for(int i = 0 ; i < length ; i++) {
				if (sMap.containsKey(s.charAt(i)) && sMap.containsKey(s.charAt(i))) {
					if (sMap.get(s.charAt(i)) != tMap.get(t.charAt(i))) {
						return false;
					}
				} else if (!sMap.containsKey(s.charAt(i)) && !tMap.containsKey(t.charAt(i))) {
					sMap.put(s.charAt(i), i);
					tMap.put(t.charAt(i), i);
				} else {
					return false;
				}
			}

			return true;
		}
	}
}
