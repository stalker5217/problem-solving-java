package LEETCODE;

import java.util.ArrayList;
import java.util.List;

public class _589 {
	// Definition for a Node.
	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	private static class Solution {
		public List<Integer> preorder(Node root) {
			List<Integer> answer = new ArrayList<>();

			if (root != null) {
				helper(answer, root);
			}

			return answer;
		}

		private void helper(List<Integer> list, Node node) {
			list.add(node.val);

			for (Node child : node.children) {
				helper(list, child);
			}
		}
	}
}
