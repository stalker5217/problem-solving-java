package LEETCODE;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _215 {
	private static class Solution {
		public int findKthLargest(int[] nums, int k) {
			Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
			for(int num : nums) {
				pq.add(num);
			}

			int result = 0;
			while (k-- > 0) {
				result = pq.poll();
			}

			return result;
		}
	}
}
