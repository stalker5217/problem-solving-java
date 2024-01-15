package LEETCODE;

public class _530 {
    // Definition for a binary tree node.
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static class Solution {
        private int minDiff;
        private TreeNode prevNode;

        public int getMinimumDifference(TreeNode root) {
            minDiff = Integer.MAX_VALUE;
            prevNode = null;
            traverse(root);

            return minDiff;
        }

        private void traverse(TreeNode current) {
            if (current == null) {
                return;
            }

            traverse(current.left);
            if (prevNode != null) {
                minDiff = Math.min(minDiff, current.val - prevNode.val);
            }
            prevNode = current;
            traverse(current.right);
        }
    }
}
