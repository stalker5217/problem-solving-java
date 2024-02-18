package LEETCODE;

import java.util.HashMap;
import java.util.Map;

public class _993 {
     // Definition for a binary tree node.
     public class TreeNode {
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
        public boolean isCousins(TreeNode root, int x, int y) {
            Map<Integer, TreeNode> parentMap = new HashMap<>();
            Map<Integer, Integer> depthMap = new HashMap<>();

            parentMap.put(root.val, null);
            depthMap.put(root.val, 0);
            calculate(root, parentMap, depthMap);

            return parentMap.get(x) != parentMap.get(y) && depthMap.get(x) == depthMap.get(y);
        }

        private void calculate(TreeNode current, Map<Integer, TreeNode> parentMap, Map<Integer, Integer> depthMap) {
            TreeNode left = current.left;
            TreeNode right = current.right;

            if (left != null) {
                parentMap.put(left.val, current);
                depthMap.put(left.val, depthMap.get(current.val) + 1);
                calculate(left, parentMap, depthMap);
            }

            if (right != null) {
                parentMap.put(right.val, current);
                depthMap.put(right.val, depthMap.get(current.val) + 1);
                calculate(right, parentMap, depthMap);
            }
        }
    }
}
