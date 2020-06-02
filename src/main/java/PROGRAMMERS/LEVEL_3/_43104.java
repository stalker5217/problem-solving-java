package PROGRAMMERS.LEVEL_3;

/**
 * 타일 장식물
 */

public class _43104 {
    public static void main(String[] args) {
        Solution_43104 s = new Solution_43104();
        int n = 6;
        System.out.println(s.solution(n));
    }
}

class Solution_43104{
    public long solution(int n) {
        long[] dp = new long[n+2];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3 ; i < n+2 ; i++) dp[i] = dp[i-1] + dp[i-2];
        return 2 * (dp[n+1] + dp[n]);
    }
}
