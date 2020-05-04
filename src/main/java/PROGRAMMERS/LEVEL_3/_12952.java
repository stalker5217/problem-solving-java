package PROGRAMMERS.LEVEL_3;

/**
 * N-Queen
 */

public class _12952 {
    public static void main(String[] args) {
        Solution_12952 s = new Solution_12952();
        int n = 8;
        System.out.println(s.solution(n));
    }
}

class Solution_12952{
    private int n;
    private int promiseCnt = 0;
    private int[] queenCol;

    public int solution(int n) {
        this.n = n;
        queenCol = new int[n];

        dfs(0);
        return promiseCnt;
    }

    private void dfs(int row){
        if(row == n) {
            promiseCnt++;
            return;
        }

        for(int i = 0 ; i < n ; i++){
            queenCol[row] = i;
            if(isPromising(row)) dfs(row+1);
        }
    }

    private boolean isPromising(int row){
        for(int i = 0 ; i < row ; i++){
            if(queenCol[i] == queenCol[row]) return false;
            if(Math.abs(queenCol[row] - queenCol[i]) == Math.abs(row - i)) return false;
        }

        return true;
    }
}