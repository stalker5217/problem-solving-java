package PROGRAMMERS.LEVEL_3;

import java.util.Arrays;

/**
 * 정수 삼각형
 */

public class _43105 {
    public static void main(String[] args) {
        Solution_43105 s = new Solution_43105();
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        System.out.println(s.solution(triangle));
    }
}

class Solution_43105{
    public int solution(int[][] triangle) {
        for(int i = 1 ; i < triangle.length ; i++){
            for(int j = 0 ; j < triangle[i].length ; j++){
                if(j == 0) triangle[i][j] += triangle[i-1][j];
                else if (j == triangle[i].length - 1) triangle[i][j] += triangle[i-1][j-1];
                else triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
        }

        return Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
    }
}
