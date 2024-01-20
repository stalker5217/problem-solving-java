package LEETCODE;

import java.util.Arrays;

public class _575 {
    private static class Solution {
        public int distributeCandies(int[] candyType) {
            int maxEatCount = candyType.length / 2;
            int typeCount = (int) Arrays.stream(candyType)
                    .distinct()
                    .count();

            return Math.min(maxEatCount, typeCount);
        }
    }
}
