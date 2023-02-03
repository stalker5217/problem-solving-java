package LEETCODE;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _297 {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Codec {
		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null) {
				return "";
			}

			Queue<TreeNode> nodeQueue = new LinkedList<>();
			nodeQueue.add(root);

			StringBuilder nodeAsString = new StringBuilder();
			while (!nodeQueue.isEmpty()) {
				TreeNode cur = nodeQueue.poll();

				if (cur != null) {
					nodeAsString.append(cur.val);
					nodeQueue.add(cur.left);
					nodeQueue.add(cur.right);
				} else {
					nodeAsString.append("null");
				}
				nodeAsString.append(",");
			}

			return nodeAsString.substring(0, nodeAsString.length() - 1);
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data.length() == 0) {
				return null;
			}

			String[] nodeArr = data.split(",");

			TreeNode root = new TreeNode(Integer.parseInt(nodeArr[0]));
			Queue<TreeNode> nodeQueue = new LinkedList<>();
			nodeQueue.add(root);

			int index = 1;
			while (!nodeQueue.isEmpty()) {
				TreeNode cur = nodeQueue.poll();

				if (index < data.length() && !"null".equals(nodeArr[index])) {
					TreeNode left = new TreeNode(Integer.parseInt(nodeArr[index]));
					cur.left = left;
					nodeQueue.add(left);
				}
				index++;

				if (index < data.length() && !"null".equals(nodeArr[index])) {
					TreeNode right = new TreeNode(Integer.parseInt(nodeArr[index]));
					cur.right = right;
					nodeQueue.add(right);
				}
				index++;
			}

			return root;
		}
	}
}
