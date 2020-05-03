package PROGRAMMERS.LEVEL_2;

/**
 * 땅따먹기
 */

public class _12913 {
    public static void main(String[] args) {
        Solution_12913 s = new Solution_12913();
        int[][] land = {
                {1,2,3,5},
                {5,6,7,8},
                {4,3,2,1}
        };
        System.out.println(s.solution(land));
    }
}

class Solution_12913{
    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];

        dp[0][0] = land[0][0]; dp[0][1] = land[0][1]; dp[0][2] = land[0][2]; dp[0][3] = land[0][3];
        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[i].length ; j++){

                int max = -1;
                for(int k = 0 ; k < dp[i-1].length ; k++){
                    if(j == k) continue;
                    max = Math.max(max, dp[i - 1][k]);
                }

                dp[i][j] = max + land[i][j];
            }
        }

        int answer = -1;
        for(int k = 0 ; k < dp[dp.length - 1].length ; k++){
            answer = Math.max(answer, dp[dp.length - 1][k]);
        }

        return answer;
    }
}
