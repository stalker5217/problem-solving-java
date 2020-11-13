package PROGRAMMERS.LEVEL_2;

/**
 * 쿼드압축 후 개수 세기
 */

public class _68936 {
    public static void main(String[] args) {
        Solution_68936 s = new Solution_68936();
        int[][] arr = {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };
        for(int cur : s.solution(arr)){
            System.out.println(cur);
        }
    }
}

class Solution_68936{
    int[] answer;

    public int[] solution(int[][] arr) {
        answer = new int[2];
        compress(arr, 0, 0, arr.length);

        return answer;
    }

    private void compress(int[][] arr, int startRow, int startCol, int size){
        boolean isAllSame = true;
        int baseNum = arr[startRow][startCol];
        for(int i = startRow ; i < startRow + size ; i++){
            for(int j = startCol ; j < startCol + size ; j++){
                if(arr[i][j] != baseNum){
                    isAllSame = false;
                    break;
                }
            }
        }

        if(isAllSame) answer[baseNum]++;
        else{
            for(int i = 0 ; i < 2 ; i++){
                for(int j = 0 ; j < 2 ; j++){
                    compress(arr, startRow + size / 2 * i, startCol + size / 2 * j, size / 2);
                }
            }
        }
    }
}
