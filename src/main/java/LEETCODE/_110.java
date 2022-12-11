package LEETCODE;

public class _110 {
	// Definition for a binary tree node.
	public class TreeNode {
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
		public boolean isBalanced(TreeNode root) {
			if (root == null) {
				return true;
			}

			return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1
				&& isBalanced(root.left)
				&& isBalanced(root.right);
		}

		private int getHeight(TreeNode node) {
			if (node == null) {
				return 0;
			}

			return 1 + Math.max(getHeight(node.left), getHeight(node.right));
		}
	}
}
