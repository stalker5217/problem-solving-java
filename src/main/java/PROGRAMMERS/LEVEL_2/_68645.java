package PROGRAMMERS.LEVEL_2;

import java.util.ArrayList;
import java.util.List;

/**
 * 삼각 달팽이
 */

public class _68645 {
    public static void main(String[] args) {
        Solution_68645 s = new Solution_68645();
        int n = 5;
        for(int value : s.solution(n)){
            System.out.println(value);
        }
    }
}

class Solution_68645{
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        makeTriangle(triangle, n, 0, 0, 1);

        List<Integer> ret = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j <= i ; j++){
                ret.add(triangle[i][j]);
            }
        }

        return ret.stream().mapToInt(c->c).toArray();
    }

    private void makeTriangle(int[][] triangle, int size, int start_row, int start_col, int start_number){
        for(int i = 0 ; i < size ; i++, start_number++) triangle[start_row + i][start_col] = start_number;
        for(int i = 1 ; i < size ; i++, start_number++) triangle[start_row + size - 1][start_col + i] = start_number;
        for(int i = 1 ; i < size - 1 ; i++, start_number++) triangle[start_row + size - 1 - i][start_col + size - 1 - i] = start_number;

        if(size > 3) makeTriangle(triangle, size - 3, start_row + 2, start_col + 1, start_number);
    }
}
