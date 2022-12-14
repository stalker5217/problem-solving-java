package LEETCODE;

import java.util.ArrayList;
import java.util.List;

public class _39 {
	private static class Solution {
		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			List<Integer> picked = new ArrayList<>();
			List<List<Integer>> answer = new ArrayList<>();
			helper(candidates, target, picked, 0, answer);

			return answer;
		}

		private void helper(
			final int[] candidates,
			final int target,
			final List<Integer> picked,
			int index,
			final List<List<Integer>> answer
		) {
			int sum = picked.stream().mapToInt(c -> c).sum();

			if (sum >= target) {
				if (sum == target) {
					answer.add(new ArrayList<>(picked));
				}

				return;
			}

			for (int i = index ; i < candidates.length ; i++) {
				picked.add(candidates[i]);
				helper(candidates, target, picked, i, answer);
				picked.remove(picked.size() - 1);
			}
		}
	}
}
