package PROGRAMMERS.LEVEL_3;

/**
 * 멀리 뛰기
 */

public class _12914 {
    public static void main(String[] args) {
        Solution_12914 s = new Solution_12914();
        int n = 4;
        System.out.println(s.solution(n));
    }
}

class Solution_12914{
    public long solution(int n) {
        int[] dp = new int[2001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3 ; i <= n ; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }

        return dp[n];
    }
}
