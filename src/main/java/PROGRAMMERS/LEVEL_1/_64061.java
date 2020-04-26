package PROGRAMMERS.LEVEL_1;

import java.util.ArrayList;
import java.util.List;

/**
 * 크레인 인형뽑기 게임
 */

public class _64061 {
    public static void main(String[] args) {
        Solution_64061 s = new Solution_64061();
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(s.solution(board, moves));
    }
}

class Solution_64061{
    public int solution(int[][] board, int[] moves) {
        List<Integer> pickArr = new ArrayList<>();
        int removeCnt = 0;

        for (int move : moves) {
            int col = move - 1;

            int pick = -1;
            for (int row = board.length - 1; row >= 0; row--) {
                if (board[row][col] > 0) {
                    pick = board[row][col];
                    break;
                }
            }

            if (pick != -1) {
                if (pickArr.size() > 0) {
                    if (pickArr.get(pickArr.size() - 1) == pick) {
                        pickArr.remove(pickArr.size() - 1);
                        removeCnt += 2;
                    } else {
                        pickArr.add(pick);
                    }
                } else {
                    pickArr.add(pick);
                }
            }
        }

        return removeCnt;
    }
}
