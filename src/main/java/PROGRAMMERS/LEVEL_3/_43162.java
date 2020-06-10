package PROGRAMMERS.LEVEL_3;

/**
 * 네트워크
 */

public class _43162 {
    public static void main(String[] args) {
        Solution_43162 s = new Solution_43162();
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(s.solution(n, computers));
    }
}

class Solution_43162{
    private boolean[] isVisit;

    public int solution(int n, int[][] computers) {
        isVisit = new boolean[n];
        int ret = 0;
        for(int i = 0 ; i < n ; i++){
            if(!isVisit[i]){
                dfs(i, computers);
                ret++;
            }
        }

        return ret;
    }

    private void dfs(int idx, int[][] computers){
        isVisit[idx] = true;
        for(int i = 0 ; i < computers[idx].length ; i++){
            if(computers[idx][i] == 1 && !isVisit[i]) dfs(i, computers);
        }
    }
}
