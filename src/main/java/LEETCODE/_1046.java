package LEETCODE;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _1046 {
	private static class Solution {
		public int lastStoneWeight(int[] stones) {
			PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
			for (int stone : stones) {
				pq.add(stone);
			}

			while (pq.size() > 1) {
				int y = pq.poll();
				int x = pq.poll();

				if (y - x > 0) {
					pq.add(y - x);
				}
			}

			return pq.isEmpty() ? 0 : pq.poll();
		}
	}
}
