package PROGRAMMERS.LEVEL_2;

/**
 * 탑
 */

public class _42588 {
    public static void main(String[] args) {
        Solution_42588 s = new Solution_42588();
        int[] heights = {6,9,5,7,4};
        for(int cur : s.solution(heights)){
            System.out.println(cur);
        }
    }
}

class Solution_42588{
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        for(int i = 0 ; i < heights.length ; i++){
            for(int j = i - 1 ; j >= 0 ; j--){
                if(heights[j] > heights[i]){
                    answer[i] = j+1;
                    break;
                }
            }
        }

        return answer;
    }
}
