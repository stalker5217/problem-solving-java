package LEETCODE;

public class _520 {
    private static class Solution {
        public boolean detectCapitalUse(String word) {
            int upperCaseCount = 0;
            int lowerCaseCount = 0;
            for (int i = 0; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    upperCaseCount++;
                } else if (Character.isLowerCase(word.charAt(i))) {
                    lowerCaseCount++;
                }
            }

            if (upperCaseCount == word.length() || lowerCaseCount == word.length()) {
                return true;
            }

            return upperCaseCount == 1 && Character.isUpperCase(word.charAt(0));
        }
    }
}
