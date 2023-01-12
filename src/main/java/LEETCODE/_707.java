package LEETCODE;

public class _707 {
	private static class MyLinkedList {
		private int length;
		private final Node dummyHead;

		public MyLinkedList() {
			this.length = 0;
			dummyHead = new Node(-1);
		}

		public int get(int index) {
			if (length <= index) {
				return -1;
			}

			Node cur = dummyHead;
			while (index-- >= 0) {
				cur = cur.next;
			}

			return cur.val;
		}

		public void addAtHead(int val) {
			Node newHead = new Node(val);
			newHead.next = dummyHead.next;
			newHead.prev = dummyHead;

			if (dummyHead.next != null) {
				dummyHead.next.prev = newHead;
			}
			dummyHead.next = newHead;

			length++;
		}

		public void addAtTail(int val) {
			Node newTail = new Node(val);

			Node cur = dummyHead;
			while (cur.next != null) {
				cur = cur.next;
			}

			cur.next = newTail;
			newTail.prev = cur;

			length++;
		}

		public void addAtIndex(int index, int val) {
			if (length < index) {
				return;
			}

			Node cur = dummyHead;
			index--;
			while (index-- >= 0) {
				cur = cur.next;
			}

			Node newNode = new Node(val);
			newNode.prev = cur;

			if (cur.next != null) {
				newNode.next = cur.next;
				cur.next.prev = newNode;
			}

			cur.next = newNode;

			length++;
		}

		public void deleteAtIndex(int index) {
			if (length <= index) {
				return;
			}

			Node cur = dummyHead;
			while (index-- >= 0) {
				cur = cur.next;
			}

			if (cur.next != null) {
				cur.next.prev = cur.prev;
			}
			if (cur.prev != null) {
				cur.prev.next = cur.next;
			}

			length--;
		}

		private static class Node {
			int val;
			Node next;
			Node prev;

			public Node(int val) {
				this.val = val;
				this.next = null;
				this.prev = null;
			}
		}
	}

	/**
	 * Your MyLinkedList object will be instantiated and called as such:
	 * MyLinkedList obj = new MyLinkedList();
	 * int param_1 = obj.get(index);
	 * obj.addAtHead(val);
	 * obj.addAtTail(val);
	 * obj.addAtIndex(index,val);
	 * obj.deleteAtIndex(index);
	 */
}
