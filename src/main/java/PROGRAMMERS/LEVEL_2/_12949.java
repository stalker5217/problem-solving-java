package PROGRAMMERS.LEVEL_2;

/**
 * 행렬의 곱셈
 */

public class _12949 {
    public static void main(String[] args) {
        Solution_12949 s = new Solution_12949();
        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
        for(int[] arr : s.solution(arr1, arr2)){
            for(int cur : arr){
                System.out.print(cur + " ");
            }
            System.out.println();
        }
    }
}

class Solution_12949{
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i = 0 ; i < answer.length ; i++){
            for(int j = 0 ; j < answer[0].length ; j++){
                for(int k = 0 ; k < arr1[0].length ; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}
