package PROGRAMMERS.LEVEL_3;

/**
 * 순위
 */

public class _49191 {
    public static void main(String[] args) {
        Solution_49191 s = new Solution_49191();
        int n = 5;
        int[][] results = {
                {4, 3},
                {4, 2},
                {3, 2},
                {1, 2},
                {2, 5}
        };
        System.out.println(s.solution(n, results));
    }
}

class Solution_49191{
    public int solution(int n, int[][] results) {
        int[][] adj = new int[n+1][n+1];
        for(int[] result : results) {
            adj[result[0]][result[1]] = 1;
            adj[result[1]][result[0]] = -1;
        }

        // Floyd
        for(int k = 1 ; k <= n ; k++) {
            for(int i = 1 ; i <= n ; i++) {
                for(int j = 1 ; j <= n ; j++) {
                    if(adj[i][k] != 0 && adj[i][k] == adj[k][j]) {
                        adj[i][j] = adj[i][k];
                    }
                }
            }
        }

        int answer = 0;
        for(int i = 1 ; i <= n ; i++) {
            int count = n;
            for(int j = 1 ; j <= n ; j++) {
                if(adj[i][j] != 0) count--;
            }
            // 자기 자신 제외 판별 가능
            if(count == 1) answer++;
        }

        return answer;
    }
}
