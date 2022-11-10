package LEETCODE;

import java.util.ArrayList;
import java.util.List;

public class _102 {
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
		public List<List<Integer>> levelOrder(TreeNode root) {
			List<List<Integer>> answer = new ArrayList<>();

			if (root != null) {
				helper(answer, root, 1);
			}

			return answer;
		}

		private void helper(List<List<Integer>> list, TreeNode node, int level) {
			if (level > list.size()) {
				list.add(new ArrayList<>());
			}

			list.get(level - 1).add(node.val);

			if (node.left != null) {
				helper(list, node.left, level + 1);
			}

			if (node.right != null) {
				helper(list, node.right, level + 1);
			}
		}
	}
}
