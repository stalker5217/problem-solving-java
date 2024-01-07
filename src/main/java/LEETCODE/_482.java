package LEETCODE;

public class _482 {
    private static class Solution {
        public String licenseKeyFormatting(String s, int k) {
            StringBuilder reformattedResult = new StringBuilder();
            int appendCount = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) != '-') {
                    reformattedResult.insert(0, Character.toUpperCase(s.charAt(i)));
                    appendCount++;
                }

                if (appendCount == k) {
                    reformattedResult.insert(0, '-');
                    appendCount = 0;
                }
            }

            boolean isDashFirst = reformattedResult.indexOf("-") == 0;
            return isDashFirst ? reformattedResult.substring(1) : reformattedResult.toString();
        }
    }
}
