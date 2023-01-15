package LEETCODE;

public class _25 {

	// Definition for singly-linked list.
	private static class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	private static class Solution {
		public ListNode reverseKGroup(ListNode head, int k) {
			ListNode cur = head;
			int count = k;
			for (int i = 0 ; i < k ; i++) {
				if (cur == null) {
					return head;
				}

				cur = cur.next;
			}

			cur = head;
			ListNode prev = null;
			for (int i = 0 ; i < k ; i++) {
				ListNode next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
			}

			head.next = reverseKGroup(cur, k);

			return prev;
		}
	}
}
