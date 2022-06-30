package PROGRAMMERS.LEVEL_2;

public class _12902 {
	class Solution {
		public int solution(int n) {
			if(n % 2 == 1) return 0;

			long[] dp = new long[n+1];
			dp[0] = 1;
			dp[2] = 3;
			for(int i = 4 ; i <= n ; i += 2) {
				dp[i] = (dp[i - 2] * 3);
				for(int j = 4 ; j <= i ; j += 2) {
					dp[i] += (dp[i - j] * 2);
				}
				dp[i] %= 1000000007;
			}

			return (int)dp[n];
		}
	}
}
