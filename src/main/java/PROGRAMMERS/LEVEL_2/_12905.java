package PROGRAMMERS.LEVEL_2;

/**
 * 가장 큰 정사각형 찾기
 */

public class _12905 {
    public static void main(String[] args) {
        Solution_12905 s = new Solution_12905();
        int[][] board = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 1, 0}
        };
        System.out.println(s.solution(board));
    }
}

class Solution_12905{
    public int solution(int [][]board){
        int maxLen = 0;

        for(int i = 0 ; i < board.length ; i++) maxLen = Math.max(maxLen, board[i][0]);
        for(int j = 0 ; j < board[0].length ; j++) maxLen = Math.max(maxLen, board[0][j]);

        for(int i = 1 ; i < board.length ; i++){
            for(int j = 1 ; j < board[i].length ; j++){
                if(board[i][j] > 0){
                    board[i][j] = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1])) + 1;
                    maxLen = Math.max(maxLen, board[i][j]);
                }
            }
        }

        return maxLen * maxLen;
    }
}
