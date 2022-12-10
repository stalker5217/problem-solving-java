package LEETCODE;

import java.util.HashMap;
import java.util.Map;

public class _437 {

	// Definition for a binary tree node.
	private static class TreeNode {
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
		public int pathSum(TreeNode root, int targetSum) {
			Map<Long, Integer> sumHash = new HashMap<>();
			sumHash.put(0L, 1);
			return helper(root, 0L, targetSum, sumHash);
		}

		private int helper(TreeNode node, long sum, int targetSum, Map<Long, Integer> sumHash) {
			if (node == null) {
				return 0;
			}

			sum += node.val;

			int cnt = 0;
			if (sumHash.getOrDefault(sum - targetSum, 0) > 0) {
				cnt += sumHash.get(sum - targetSum);
			}

			sumHash.put(sum, sumHash.getOrDefault(sum, 0) + 1);

			cnt += helper(node.left, sum, targetSum, sumHash);
			cnt += helper(node.right, sum, targetSum, sumHash);

			sumHash.put(sum, sumHash.get(sum) - 1);

			return cnt;
		}
	}
}
