package LEETCODE;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _841 {
	private static class Solution {
		public boolean canVisitAllRooms(List<List<Integer>> rooms) {
			int n = rooms.size();
			boolean[] visit = new boolean[n];
			Queue<Integer> q = new LinkedList<>();
			q.add(0);

			while (!q.isEmpty()) {
				int cur = q.poll();
				visit[cur] = true;

				for(int next : rooms.get(cur)) {
					if (!visit[next]) {
						q.add(next);
					}
				}
			}

			for(boolean cur : visit) {
				if (!cur) {
					return false;
				}
			}

			return true;
		}
	}
}
