package LEETCODE;

public class _543 {

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
		private int answer = 0;

		public int diameterOfBinaryTree(TreeNode root) {
			answer = 0;
			helper(root);
			return answer;
		}

		private int helper(TreeNode node) {
			if (node == null) {
				return 0;
			}

			int left = helper(node.left);
			int right = helper(node.right);

			answer = Math.max(answer, left + right);

			return Math.max(left, right) + 1;
		}
	}
}
