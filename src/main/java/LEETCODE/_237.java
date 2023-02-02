package LEETCODE;

public class _237 {

	// Definition for a binary tree node.
	private static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}

	private static class Solution {
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			if (root == null || root.val == p.val || root.val == q.val) {
				return root;
			}

			TreeNode left  = lowestCommonAncestor(root.left, p, q);
			TreeNode right = lowestCommonAncestor(root.right, p, q);

			if (left == null) {
				return right;
			} else if (right == null) {
				return left;
			}

			return root;
		}
	}
}
