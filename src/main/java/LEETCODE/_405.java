package LEETCODE;

public class _405 {
    private static class Solution {
        private static char[] hexMap = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        public String toHex(int num) {
            if (num == 0) {
                return "0";
            }

            StringBuilder result = new StringBuilder();
            while (num != 0) {
                result.insert(0, hexMap[(num & 15)]);
                num = (num >>> 4);
            }
            return result.toString();
        }
    }
}
