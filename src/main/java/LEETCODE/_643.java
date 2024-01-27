package LEETCODE;

import java.util.Arrays;

public class _643 {
    private static class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int sum = Arrays.stream(nums, 0, k).sum();
            int maxSum = Math.max(Integer.MIN_VALUE, sum);
            for (int i = k; i < nums.length; i++) {
                sum += nums[i];
                sum -= nums[i - k];

                maxSum = Math.max(maxSum, sum);
            }

            return (double) maxSum / k;
        }
    }
}
