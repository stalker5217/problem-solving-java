package PROGRAMMERS.LEVEL_2;

/**
 * 카펫
 */

public class _42842 {
    public static void main(String[] args) {
        Solution_42842 s = new Solution_42842();
        int brown = 18;
        int red = 6;
        for(int cur : s.solution(brown, red)){
            System.out.println(cur);
        }
    }
}

class Solution_42842{
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];

        // brown + red = row * col
        // brown = (row * 2) + (col * 2) - 4

        boolean findResult = false;
        for(int col = 3 ; ; col++){
            for(int row = 3 ; row <= col ; row++){
                if(brown + red == row * col
                && brown == (row * 2) + (col * 2) - 4){
                    findResult = true;
                    answer[0] = col;
                    answer[1] = row;
                    break;
                }
            }
            if(findResult) break;
        }

        return answer;
    }
}
