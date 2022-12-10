package LEETCODE;

public class _328 {
	// Definition for singly-linked list.
	private static class ListNode {
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
		public ListNode oddEvenList(ListNode head) {
			ListNode cur = head;
			ListNode oddDummy = new ListNode();
			ListNode evenDummy = new ListNode();
			ListNode odd = oddDummy;
			ListNode even = evenDummy;

			while (cur != null) {
				odd.next = cur;
				even.next = cur.next;

				cur = cur.next;
				if (cur != null) {
					cur = cur.next;
				}

				odd = odd.next;
				even = even.next;
			}

			odd.next = evenDummy.next;

			return oddDummy.next;
		}
	}
}
