package LEETCODE;

public class _744 {
    private static class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            return (char) new String(letters)
                    .chars()
                    .sorted()
                    .filter(i -> i > target)
                    .findFirst()
                    .orElse(letters[0]);
        }
    }
}
