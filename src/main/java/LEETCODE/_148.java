package LEETCODE;

public class _148 {

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
		public ListNode sortList(ListNode head) {
			return mergeSort(head);
		}

		private ListNode mergeSort(ListNode node) {
			if (node == null || node.next == null) {
				return node;
			}

			ListNode mid = findMid(node);

			ListNode front = node;
			ListNode rear = mid.next;
			mid.next = null;

			front = mergeSort(front);
			rear = mergeSort(rear);

			return mergeArea(front, rear);
		}

		private ListNode findMid(ListNode node) {
			ListNode slow = node;
			ListNode fast = node;

			while (slow.next != null && fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}

			return slow;
		}

		private ListNode mergeArea(ListNode front, ListNode rear) {
			ListNode dummy = new ListNode(-1);
			ListNode current = dummy;

			while (front != null && rear != null) {
				if (front.val <= rear.val) {
					current.next = front;
					current = current.next;
					front = front.next;
				} else {
					current.next = rear;
					current = current.next;
					rear = rear.next;
				}
			}

			while (front != null) {
				current.next = front;
				current = current.next;
				front = front.next;
			}

			while (rear != null) {
				current.next = rear;
				current = current.next;
				rear = rear.next;
			}

			return dummy.next;
		}
	}
}
