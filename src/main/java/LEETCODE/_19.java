package LEETCODE;

import java.util.Stack;

public class _19 {

	// Definition for singly-linked list.
	private static class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	private static class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			ListNode dummy = new ListNode(-1);
			dummy.next = head;

			ListNode cur = dummy;
			Stack<ListNode> st = new Stack<>();

			while (cur != null) {
				st.push(cur);
				cur = cur.next;
			}

			while (n-- > 0) {
				st.pop();
			}

			ListNode pop = st.pop();
			pop.next = pop.next.next;

			return dummy.next;
		}
	}
}
