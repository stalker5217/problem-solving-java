package LEETCODE;

public class _693 {
    private static class Solution {
        public boolean hasAlternatingBits(int n) {
            int previous = 2;
            while (n > 0) {
                if (n % 2 == previous) {
                    return false;
                }
                previous = n % 2;
                n = n >> 1;
            }

            return true;
        }
    }
}
