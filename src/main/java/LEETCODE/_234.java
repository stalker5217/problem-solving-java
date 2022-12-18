package LEETCODE;

public class _234 {

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
		public boolean isPalindrome(ListNode head) {
			ListNode slow = head;
			ListNode fast = head;
			ListNode reversedHead = null;

			boolean oddCount = false;
			while (fast != null) {
				fast = fast.next;
				oddCount = true;

				if (fast != null) {
					fast = fast.next;

					ListNode temp = slow.next;
					slow.next = reversedHead;
					reversedHead = slow;
					slow = temp;

					oddCount = false;
				}
			}

			ListNode front = reversedHead;
			ListNode rear = oddCount ? slow.next : slow;

			while (front != null && rear != null) {
				if (front.val != rear.val) {
					return false;
				}

				front = front.next;
				rear = rear.next;
			}

			return true;
		}
	}
}
