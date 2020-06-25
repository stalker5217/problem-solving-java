package PROGRAMMERS.LEVEL_3;

/**
 * 거스름돈
 */

public class _12907 {
    public static void main(String[] args) {
        Solution_12907 s = new Solution_12907();
        int n = 5;
        int[] money = {1, 2, 5};
        System.out.println(s.solution(n, money));
    }
}

class Solution_12907{
    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int m : money){
            for(int i = 1 ; i <= n ; i++){
                if(i - m >= 0) dp[i] = (dp[i] + dp[i-m]) % 1000000007;
            }
        }

        return dp[n];
    }
}