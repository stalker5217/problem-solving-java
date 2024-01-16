package LEETCODE;

public class _541 {
    private static class Solution {
        public String reverseStr(String s, int k) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length(); i = i + 2 * k) {
                int mid = i + k;
                result.append(new StringBuilder(s.substring(i, Math.min(mid, s.length()))).reverse());
                if (mid < s.length()) {
                    result.append(s, mid, Math.min(mid + k, s.length()));
                }
            }

            return result.toString();
        }
    }
}
