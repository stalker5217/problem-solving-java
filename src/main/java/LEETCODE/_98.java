package LEETCODE;

public class _98 {
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
		public boolean isValidBST(TreeNode root) {
			long min = Integer.MIN_VALUE - 1L;
			long max = Integer.MAX_VALUE + 1L;

			return helper(root, min, max);
		}

		private boolean helper(TreeNode node, long min, long max) {
			if (node == null) {
				return true;
			}

			if (node.val <= min || node.val >= max) {
				return false;
			}

			boolean left = helper(node.left, min, node.val);
			boolean right = helper(node.right, node.val, max);

			return left & right;
		}
	}
}
