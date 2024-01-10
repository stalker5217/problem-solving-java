package LEETCODE;

import java.util.*;

public class _501 {

    // Definition for a binary tree node.
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static class Solution {
        public int[] findMode(TreeNode root) {
            Map<Integer, Integer> freqMap = new HashMap<>();
            count(root, freqMap);

            Optional<Integer> maxValueOptional = freqMap.entrySet()
                    .stream()
                    .sorted(Comparator.comparingInt(Map.Entry::getValue))
                    .map(Map.Entry::getValue)
                    .max(Integer::compareTo);

            if (maxValueOptional.isEmpty()) {
                return new int[0];
            }

            Integer maxValue = maxValueOptional.get();
            List<Integer> result = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e: freqMap.entrySet()) {
                if (maxValue.equals(e.getValue())) {
                    result.add(e.getKey());
                }
            }

            return result.stream().mapToInt(c -> c).toArray();
        }

        public void count(TreeNode node, Map<Integer, Integer> freqMap) {
            if (node == null) {
                return;
            }

            freqMap.put(node.val, freqMap.getOrDefault(node.val, 0) + 1);
            count(node.left, freqMap);
            count(node.right, freqMap);
        }
    }
}
