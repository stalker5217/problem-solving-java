package LEETCODE;

public class _947 {
	class Solution {
		public int removeStones(int[][] stones) {
			DisjointSet disjointSet = new DisjointSet(stones.length);
			int stoneCnt = stones.length;
			for (int i = 0; i < stones.length; i++) {
				for (int j = i + 1; j < stones.length; j++) {
					if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
						boolean merge = disjointSet.union(i, j);
						if (merge) {
							stoneCnt--;
						}
					}
				}
			}

			return stones.length - stoneCnt;
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

			public boolean union(int u, int v) {
				u = find(u);
				v = find(v);

				boolean merge = false;
				if (u != v) {
					merge = true;
					parent[v] = u;
				}

				return merge;
			}
		}
	}
}
