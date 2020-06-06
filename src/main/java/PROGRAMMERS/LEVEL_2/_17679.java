package PROGRAMMERS.LEVEL_2;

/**
 * [1차] 프렌즈4블록
 */

public class _17679 {
    public static void main(String[] args) {
        Solution_17679 s = new Solution_17679();
        int m = 4, n = 4;
        String[] board = {"ABCD", "BACE", "BCDD", "BCDD"};
        System.out.println(s.solution(m, n, board));
    }
}

class Solution_17679{
    public int solution(int m, int n, String[] boardstr) {
        int[][] board = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = boardstr[i].charAt(j) - 'A' + 1;
            }
        }

        int removeCnt = 0;
        while(true){
            // 삭제 대상 잡기
            boolean[][] removeTarget = new boolean[m][n];
            boolean willDelete = false;
            for(int i = 0 ; i < m ; i++){
                for(int j = 0 ; j < n ; j++){

                    if(board[i][j] > 0 && i + 1 < m && j + 1 < n){
                        boolean isAllSame = true;
                        if(board[i][j] != board[i+1][j]) isAllSame = false;
                        if(board[i][j] != board[i][j+1]) isAllSame= false;
                        if(board[i][j] != board[i+1][j+1]) isAllSame = false;

                        if(isAllSame){
                            willDelete = true;
                            removeTarget[i][j] = true;
                            removeTarget[i+1][j] = true;
                            removeTarget[i][j+1] = true;
                            removeTarget[i+1][j+1] = true;
                        }
                    }
                }
            }

            if(!willDelete) break;

            // 삭제
            for(int i = 0 ; i < m ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(removeTarget[i][j]){
                        removeCnt++;
                        board[i][j] = 0;
                    }
                }
            }

            // 블럭 내리기
            for(int i = m-1 ; i >= 0 ; i--){
                for(int j = 0 ; j < n ; j++){
                    if(board[i][j] == 0){
                        int targetIdx = i-1;
                        while(targetIdx >= 0){
                            if(board[targetIdx][j] > 0){
                                break;
                            }
                            targetIdx--;
                        }
                        if(targetIdx >= 0){
                            board[i][j] = board[targetIdx][j];
                            board[targetIdx][j] = 0;
                        }
                    }
                }
            }
        }

        return removeCnt;
    }
}
