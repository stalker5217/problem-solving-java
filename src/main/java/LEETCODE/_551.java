package LEETCODE;

public class _551 {
    private static class Solution {
        public boolean checkRecord(String s) {
            int absentCount = 0;
            int consecutiveLateDays = 0;
            int maxConsecutiveLateDays = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'P') {
                    consecutiveLateDays = 0;
                } else if (s.charAt(i) == 'A') {
                    consecutiveLateDays = 0;
                    absentCount++;
                } else {
                    consecutiveLateDays++;
                    maxConsecutiveLateDays = Math.max(maxConsecutiveLateDays, consecutiveLateDays);
                }
            }

            if (absentCount >= 2 || maxConsecutiveLateDays >= 3) {
                return false;
            }

            return true;
        }
    }
}
