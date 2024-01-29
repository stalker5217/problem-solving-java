package LEETCODE;

public class _674 {
    private static class Solution {
        public int findLengthOfLCIS(int[] nums) {
            int previous = Integer.MIN_VALUE;
            int maxContinueCount = 0;
            int coutinueCount = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > previous) {
                    coutinueCount++;
                } else {
                    coutinueCount = 1;
                }

                previous = nums[i];
                maxContinueCount = Math.max(maxContinueCount, coutinueCount);
            }

            return maxContinueCount;
        }
    }
}
