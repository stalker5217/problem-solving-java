package LEETCODE;

public class _108 {

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
		public TreeNode sortedArrayToBST(int[] nums) {
			return selectNode(nums, 0, nums.length - 1);
		}

		private TreeNode selectNode(int[] nums, int start, int end) {
			if (start > end) {
				return null;
			}

			int mid = (start + end) / 2;
			TreeNode node = new TreeNode();

			node.val = nums[mid];
			node.left = selectNode(nums, start, mid - 1);
			node.right = selectNode(nums, mid + 1, end);

			return node;
		}
	}
}
