package LEETCODE;

public class _101 {
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
		public boolean isSymmetric(TreeNode root) {
			return helper(root.left, root.right);
		}

		private boolean helper(TreeNode a, TreeNode b) {
			if (a == null && b == null) {
				return true;
			} else if (a == null || b == null) {
				return false;
			} else if (a.val != b.val) {
				return false;
			}

			return helper(a.left, b.right) && helper(a.right, b.left);
		}
	}
}
