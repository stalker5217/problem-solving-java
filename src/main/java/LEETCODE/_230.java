package LEETCODE;

public class _230 {

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
		private int seq;
		private int target;
		private int value;

		public int kthSmallest(TreeNode root, int k) {
			seq = 0;
			target = k;
			value = 0;

			inorder(root);

			return value;
		}

		private void inorder(TreeNode node) {
			if (node.left != null) {
				inorder(node.left);
			}

			seq++;
			if (seq == target) {
				value = node.val;
			}

			if (node.right != null) {
				inorder(node.right);
			}
		}
	}
}
