package PROGRAMMERS.LEVEL_4;

import java.util.Arrays;

/**
 * 최적의 행렬 곱셈
 */

public class _12942 {
    public static void main(String[] args) {
        Solution_12942 s = new Solution_12942();
        int[][] matrix_sizes = {{5, 3}, {3, 10}, {10, 6}};
        System.out.println(s.solution(matrix_sizes));
    }
}

class Solution_12942{
    int[][] dp = new int[201][201];
    int[][] matrixSize = new int[201][2];

    public int solution(int[][] matrix_sizes) {

        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        for(int i = 0 ; i < matrix_sizes.length ; i++){
            System.arraycopy(matrix_sizes[i], 0, matrixSize[i + 1], 0, matrix_sizes[i].length);
        }

        return getAnswer(1, matrix_sizes.length);
    }

    private int getAnswer(int a, int b){
        if(a == b) return 0;
        if(dp[a][b] > 0) return dp[a][b];

        int ans = 987654321;
        for(int i = a ; i < b ; i++){
            ans = Math.min(ans, getAnswer(a, i) + getAnswer(i+1, b) + matrixSize[a][0] * matrixSize[b][1] * matrixSize[i][1]);
        }
        dp[a][b] = ans;

        return ans;
    }
}