package LEETCODE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _210 {
	private static class Solution {
		public int[] findOrder(int numCourses, int[][] prerequisites) {
			List<List<Integer>> adjacent = new ArrayList<>();
			for (int i = 0 ; i < numCourses ; i++) {
				adjacent.add(new ArrayList<>());
			}
			int[] indegree = new int[numCourses];

			for (int[] prerequisite : prerequisites) {
				adjacent.get(prerequisite[1]).add(prerequisite[0]);
				indegree[prerequisite[0]]++;
			}

			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < indegree.length; i++) {
				if (indegree[i] == 0) {
					q.offer(i);
				}
			}

			List<Integer> answer = new ArrayList<>();
			while (!q.isEmpty()) {
				int current = q.poll();
				answer.add(current);

				for (int to : adjacent.get(current)) {
					if (--indegree[to] == 0) {
						q.add(to);
					}
				}
			}

			if (answer.size() < numCourses) {
				answer.clear();
			}

			return answer.stream().mapToInt(c -> c).toArray();
		}
	}
}
