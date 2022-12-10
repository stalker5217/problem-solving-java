package LEETCODE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class _815 {
	private static class Solution {
		public int numBusesToDestination(int[][] routes, int source, int target) {
			if (source == target) {
				return 0;
			}

			List<Set<Integer>> stationSets = new ArrayList<>();
			for (int i = 0 ; i < routes.length ; i++) {
				Set<Integer> stationSet = new HashSet<>();
				for (int j = 0 ; j < routes[i].length ; j++) {
					stationSet.add(routes[i][j]);
				}

				stationSets.add(stationSet);
			}

			List<List<Integer>> adjacent = new ArrayList<>();
			for (int i = 0 ; i < stationSets.size() ; i++) {
				List<Integer> connect = new ArrayList<>();
				Set<Integer> fromRoute  = stationSets.get(i);
				for (int j = 0 ; j < stationSets.size() ; j++) {
					Set<Integer> toRoute = stationSets.get(j);
					if (!Collections.disjoint(fromRoute, toRoute)) {
						connect.add(j);
					}
				}

				adjacent.add(connect);
			}

			boolean[] visit = new boolean[stationSets.size()];
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0 ; i < stationSets.size() ; i++) {
				if (stationSets.get(i).contains(source)) {
					visit[i] = true;
					q.add(i);
				}
			}

			int take = 0;
			while(!q.isEmpty()) {
				take++;
				int size = q.size();
				while (size-- > 0) {
					int current = q.poll();

					if (stationSets.get(current).contains(target)) {
						return take;
					}

					for (int next : adjacent.get(current)) {
						if (!visit[next]) {
							visit[next] = true;
							q.add(next);
						}
					}
				}
			}

			return -1;
		}
	}
}
