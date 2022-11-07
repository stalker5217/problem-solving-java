package LEETCODE;

public class _876 {
	// Definition for singly-linked list.
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	private static class Solution {
		public ListNode middleNode(ListNode head) {
			int middle = 0;
			boolean add = false;
			ListNode cur = head;
			while(cur != null) {
				if (add) {
					middle++;
				}

				add = !add;

				cur = cur.next;
			}

			ListNode ret = head;
			while(middle-- > 0) {
				ret = ret.next;
			}

			return ret;
		}
	}
}
