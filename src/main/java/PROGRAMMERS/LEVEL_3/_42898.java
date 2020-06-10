package PROGRAMMERS.LEVEL_3;

/**
 * 등굣길
 */

public class _42898 {
    public static void main(String[] args) {
        Solution_42898 s = new Solution_42898();
        int m = 4, n = 3;
        int[][] puddles = {
                {2, 2}
        };
        System.out.println(s.solution(m, n , puddles));
    }
}

class Solution_42898{
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n+1][m+1];

        for(int[] loc : puddles){
            map[loc[1]][loc[0]] = -1;
        }

        map[1][1] = 1;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(map[i][j] >= 0){
                    int up = map[i-1][j];
                    int left = map[i][j-1];

                    if(up >= 0) map[i][j] += up;
                    if(left >= 0) map[i][j] += left;

                    map[i][j] %= 1000000007;
                }
            }
        }

        return map[n][m];
    }
}
