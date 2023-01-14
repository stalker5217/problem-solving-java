package LEETCODE;

public class _82 {

	// Definition for singly-linked list.
	private static class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}


	private static class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			ListNode dummyHead = new ListNode(-1);
			ListNode tail = dummyHead;

			ListNode cur = head;
			while (cur != null) {
				boolean duplicate = false;
				while (cur.next != null && cur.val == cur.next.val) {
					duplicate = true;
					cur = cur.next;
				}

				if (!duplicate) {
					tail.next = cur;
					tail = tail.next;
				}

				ListNode next = cur.next;
				cur.next = null;
				cur = next;
			}

			return dummyHead.next;
		}
	}
}
