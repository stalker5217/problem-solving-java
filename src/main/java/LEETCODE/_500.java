package LEETCODE;

import java.util.*;

public class _500 {
    private static class Solution {
        List<Set<Character>> keyboardSet = List.of(
                Set.of('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'),
                Set.of('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'),
                Set.of('z', 'x', 'c', 'v', 'b', 'n', 'm')
        );

        public String[] findWords(String[] words) {
            List<String> result = new ArrayList<>();
            for (String word : words) {
                Set<Integer> rowSet = new HashSet<>();
                for (int i = 0; i < word.length(); i++) {
                    for (int j = 0; j < keyboardSet.size(); j++) {
                        if (keyboardSet.get(j).contains(Character.toLowerCase(word.charAt(i)))) {
                            rowSet.add(j);
                        }
                    }
                }

                if (rowSet.size() == 1) {
                    result.add(word);
                }
            }

            return result.toArray(new String[0]);
        }
    }
}
