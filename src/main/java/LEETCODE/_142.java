package LEETCODE;

import java.util.HashSet;
import java.util.Set;

public class _142 {

	// Definition for singly-linked list.
	private static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}

	private static class Solution {
		public ListNode detectCycle(ListNode head) {
			Set<ListNode> nodeSet = new HashSet<>();

			ListNode cur = head;
			while(cur != null) {
				if (nodeSet.contains(cur)) {
					return cur;
				}

				nodeSet.add(cur);
				cur = cur.next;
			}

			return null;
		}
	}
}
