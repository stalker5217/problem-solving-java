package PROGRAMMERS.LEVEL_3;

/**
 * 2 x n 타일링
 */

public class _12900 {
    public static void main(String[] args){
        Solution_12900 s = new Solution_12900();
        int n = 4;
        System.out.println(s.solution(n));
    }
}

class Solution_12900{
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3 ; i <= n ; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }

        return dp[n];
    }
}