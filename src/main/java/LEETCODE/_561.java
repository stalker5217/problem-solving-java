package LEETCODE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class _561 {
    private static class Solution {
        public int arrayPairSum(int[] nums) {
            List<Integer> numsList = Arrays.stream(nums)
                    .boxed()
                    .sorted()
                    .toList();
            return IntStream.range(0, nums.length)
                    .filter(i -> i % 2 == 0)
                    .map(numsList::get)
                    .sum();
        }
    }
}
