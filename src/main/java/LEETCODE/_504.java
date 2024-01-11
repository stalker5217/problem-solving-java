package LEETCODE;

public class _504 {
    private static class Solution {
        public String convertToBase7(int num) {
            if (num == 0) {
                return "0";
            }

            boolean isNegative = num < 0;
            num = isNegative ? -num : num;
            StringBuilder convertedString = new StringBuilder();
            while (num > 0) {
                convertedString.append(num % 7);
                num /= 7;
            }

            if (isNegative) {
                convertedString.append("-");
            }

            return convertedString.reverse().toString();
        }
    }
}
