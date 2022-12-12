package LEETCODE;

import java.util.Arrays;

public class _547 {
	private static class Solution {
		public int findCircleNum(int[][] isConnected) {
			DisjointSet disjointSet = new DisjointSet(isConnected.length);
			for (int i = 0; i < isConnected.length; i++) {
				for (int j = i + 1; j < isConnected[i].length; j++) {
					if (isConnected[i][j] == 1) {
						disjointSet.union(i, j);
					}
				}
			}

			int answer = 0;
			for (int i = 0; i < disjointSet.parent.length; i++) {
				if (disjointSet.parent[i] == i) {
					answer++;
				}
			}

			return answer;
		}

		private static class DisjointSet {
			public int[] parent;

			public DisjointSet(int size) {
				parent = new int[size];
				for (int i = 0; i < parent.length; i++) {
					parent[i] = i;
				}
			}

			public int find(int u) {
				if (parent[u] == u) {
					return u;
				} else {
					return find(parent[u]);
				}
			}

			public void union(int u, int v) {
				u = find(u);
				v = find(v);

				parent[v] = u;
			}
		}
	}
}
