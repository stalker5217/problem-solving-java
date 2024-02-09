package LEETCODE;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _78 {
    private static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            create(nums, 0, new Stack<>(), result);

            return result;
        }

        private void create(int[] nums, int start, Stack<Integer> current, List<List<Integer>> result) {
            if (nums.length == start) {
                result.add(new ArrayList<>(current));
                return;
            }

            current.add(nums[start]);
            create(nums, start + 1, current, result);
            current.pop();

            create(nums, start + 1, current, result);
        }
    }
}
