package LEETCODE;

public class _206 {

	//Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	private static class Solution {
		public ListNode reverseList(ListNode head) {
			ListNode cur = head;
			ListNode newHead = null;

			while (cur != null) {
				ListNode oldHead = newHead;
				newHead = cur;
				cur = cur.next;
				newHead.next = oldHead;
			}

			return newHead;
		}
	}
}
