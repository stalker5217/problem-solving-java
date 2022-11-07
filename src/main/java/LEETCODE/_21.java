package LEETCODE;

public class _21 {

	 // Definition for singly-linked list.
	 private static class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }

	private static class Solution {
		public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
			ListNode dummy = new ListNode();
			ListNode cur = dummy;

			while(list1 != null && list2 != null) {
				if (list1.val < list2.val) {
					cur.next = list1;
					list1 = list1.next;
				} else {
					cur.next = list2;
					list2 = list2.next;
				}

				cur = cur.next;
			}

			while(list1 != null) {
				cur.next = list1;
				list1 = list1.next;
				cur = cur.next;
			}

			while(list2 != null) {
				cur.next = list2;
				list2 = list2.next;
				cur = cur.next;
			}

			return dummy.next;
		}
	}
}
