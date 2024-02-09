package LEETCODE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _90 {
    private static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            Arrays.sort(nums);
            create(nums, 0, new Stack<>(), result);

            return result;
        }

        private void create(int[] nums, int start, Stack<Integer> current, List<List<Integer>> result) {
            result.add(new ArrayList<>(current));

            for (int i = start; i < nums.length; i++) {
                if (i != start && nums[i] == nums[i - 1]) {
                    continue;
                }

                current.push(nums[i]);
                create(nums, i + 1, current, result);
                current.pop();
            }
        }
    }
}
