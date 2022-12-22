package LEETCODE;

import java.util.LinkedList;
import java.util.Stack;

public class _173 {
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

	private static class BSTIterator {
		private Stack<TreeNode> st;
		private TreeNode current;

		public BSTIterator(TreeNode root) {
			st = new Stack<>();
			current = root;
		}

		public int next() {
			while (current != null) {
				st.push(current);
				current = current.left;
			}

			TreeNode next = st.pop();
			current = next.right;

			return next.val;
		}

		public boolean hasNext() {
			return current == null && st.empty();
		}
	}

}
