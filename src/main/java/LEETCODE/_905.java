package LEETCODE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _905 {
    private static class Solution {
        public int[] sortArrayByParity(int[] nums) {
            List<Integer> evenList = Arrays.stream(nums)
                    .filter(i -> i % 2 == 0)
                    .boxed()
                    .toList();

            List<Integer> oddList = Arrays.stream(nums)
                    .filter(i -> i % 2 == 1)
                    .boxed()
                    .toList();

            List<Integer> results = new ArrayList<>();
            results.addAll(evenList);
            results.addAll(oddList);

            return results.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
    }
}
