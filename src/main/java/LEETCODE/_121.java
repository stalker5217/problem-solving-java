package LEETCODE;

public class _121 {
	private static class Solution {
		public int maxProfit(int[] prices) {
			int min = prices[0];
			int answer = 0;
			for(int i = 1 ; i < prices.length ; i++) {
				if (min > prices[i]) {
					min = prices[i];
				} else {
					answer = Math.max(prices[i] - min, answer);
				}
			}

			return answer;
		}
	}
}
