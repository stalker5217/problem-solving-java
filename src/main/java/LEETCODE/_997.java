package LEETCODE;

public class _997 {
	private static class Solution {
		public int findJudge(int n, int[][] trust) {
			int[] trustPerson = new int[n + 1];
			boolean[] trustOther = new boolean[n + 1];
			for (int i = 0; i < trust.length; i++) {
				trustOther[trust[i][0]] = true;
				trustPerson[trust[i][1]]++;
			}

			for (int i = 1; i <= n; i++) {
				if (trustPerson[i] == (n - 1) && !trustOther[i]) {
					return i;
				}
			}

			return -1;
		}
	}
}
