package PROGRAMMERS.LEVEL_1;

import java.util.ArrayList;
import java.util.List;

/**
 * 예산
 */

public class _12982 {
    public static void main(String[] args) {
        Solution_12982 s = new Solution_12982();
        int[] d = {1,3,2,5,4};
        int budget = 9;
        System.out.println(s.solution(d, budget));
    }
}

class Solution_12982{
    public int solution(int[] d, int budget) {
        List<Integer> dList = new ArrayList<>();

        for (int value : d) {
            dList.add(value);
        }

        int answer = dList.size();
        int sum = 0;
        for(int i = 0 ; i < dList.size() ; i++){
            sum += dList.get(i);
            if(budget < sum){
                answer = i;
                break;
            }
        }

        return answer;
    }
}
