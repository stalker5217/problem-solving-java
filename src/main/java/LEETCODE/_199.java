package LEETCODE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _199 {

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

	class Solution {
		public List<Integer> rightSideView(TreeNode root) {
			List<Integer> answer = new ArrayList<>();
			helper(root, 0, answer);
			return answer;
		}

		private void helper(TreeNode node, int level, List<Integer> answer) {
			if (node != null) {
				if (level == answer.size()) {
					answer.add(-1);
				}

				helper(node.left, level + 1, answer);
				answer.set(level, node.val);
				helper(node.right, level + 1, answer);
			}
		}
	}
}
