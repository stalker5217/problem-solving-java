package LEETCODE;

public class _563 {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        private int tilt = 0;

        public int findTilt(TreeNode root) {
			tilt = 0;
            postOrder(root);
            return tilt;
        }

        private int postOrder(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int left = postOrder(node.left);
            int right = postOrder(node.right);

            tilt += Math.abs(left - right);

            return node.val + left + right;
        }
    }
}
