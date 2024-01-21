package LEETCODE;

import java.util.Arrays;

public class _594 {
    private static class Solution {
        public int findLHS(int[] nums) {
            Arrays.sort(nums);

            Arrays.sort(nums);

            int result = 0;
            int previousValue = nums[0] - 2;
            int previousValueCount = 0;
            int currentValue = nums[0];
            int currentValueCount = 0;

            for (int i = 0; i < nums.length; i++) {
                if (currentValue == nums[i]) {
                    currentValueCount++;
                } else {
                    if (currentValue - previousValue == 1) {
                        result = Math.max(result, previousValueCount + currentValueCount);
                    }

                    previousValue = currentValue;
                    previousValueCount = currentValueCount;
                    currentValue = nums[i];
                    currentValueCount = 1;
                }
            }

            if (currentValue - previousValue == 1) {
                result = Math.max(result, previousValueCount + currentValueCount);
            }

            return result;
        }
    }
}
