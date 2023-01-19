package LEETCODE;

public class _450 {

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
		public TreeNode deleteNode(TreeNode root, int key) {
			if (root == null) {
				return null;
			} else if (root.val == key) {
				root = delete(root);
			} else {
				root.left = deleteNode(root.left, key);
				root.right = deleteNode(root.right, key);
			}

			return root;
		}

		private TreeNode delete(TreeNode target) {
			if (target.left == null && target.right == null) {
				return null;
			} else if (target.left == null || target.right == null) {
				TreeNode ret = target.left == null ? target.right : target.left;
				target.left = null;
				target.right = null;

				return ret;
			}

			TreeNode swapParent = target;
			TreeNode swap = target.right;
			while (swap.left != null) {
				swapParent = swap;
				swap = swap.left;
			}

			target.val = swap.val;

			if (swapParent == target) {
				target.right = delete(target.right);
			} else {
				swapParent.left = delete(swap);
			}

			return target;
		}
	}
}
