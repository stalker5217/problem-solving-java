package PROGRAMMERS.LEVEL_2;

import java.util.Arrays;

/**
 * H-Index
 */

public class _42747 {
    public static void main(String[] args) {
        Solution_42747 s = new Solution_42747();
        int[] citations = {7};
        System.out.println(s.solution(citations));
    }
}

class Solution_42747{
    public int solution(int[] citations) {
        int answer = -1;
        Arrays.sort(citations);

        for(int i = citations.length - 1 ; i >= 0 ; i--){
            int min = Math.min(citations[i], citations.length - i);
            answer = Math.max(answer, min);
        }

        return answer;
    }
}
