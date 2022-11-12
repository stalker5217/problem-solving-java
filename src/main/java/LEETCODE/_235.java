package LEETCODE;

public class _235 {
	// Definition for a binary tree node.
	private static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}

	private static class Solution {
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			if (root == null) {
				return root;
			}

			int small = Math.min(p.val, q.val);
			int big = Math.max(p.val, q.val);

			if (root.val >= small && root.val <= big) {
				return root;
			} else if (root.val > big) {
				return lowestCommonAncestor(root.left, p, q);
			} else {
				return lowestCommonAncestor(root.right, p, q);
			}
		}
	}
}
