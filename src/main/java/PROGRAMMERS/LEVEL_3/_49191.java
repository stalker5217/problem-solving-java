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

        int INF = 123456789;

        for(int i = 1; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                adj[i][j] = INF;
            }
        }

        for(int[] result : results){
            int a = result[0];
            int b = result[1];
            adj[a][b] = 1;
        }

        for(int k = 1 ; k <= n ; k++){
            for(int i = 1; i <= n ; i++){
                for(int j = 1 ; j <= n ; j++){
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }

        int answer = 0;
        for(int i = 1 ; i <= n; i++){
            boolean allConnect = true;
            for(int j = 1 ; j <= n ; j++){
                if(i == j) continue;
                if(adj[i][j] == INF && adj[j][i] == INF){
                    allConnect = false;
                    break;
                }
            }

            if(allConnect) answer++;
        }

        return answer;
    }
}
