package PROGRAMMERS.LEVEL_1;

import java.util.List;
import java.util.ArrayList;

/**
 * 모의고사
 */

public class _42840 {
    public static void main(String[] args) {
        Solution_42840 s = new Solution_42840();
        int[] answers = {1,3,2,4,2};
        for(int cur : s.solution(answers)){
            System.out.println(cur);
        }
    }
}

class Solution_42840{
    public int[] solution(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int cntP1 = 0, cntP2 = 0, cntP3 = 0;
        for(int i = 0 ; i < answers.length ; i++){
            if(person1[i % person1.length] == answers[i]) cntP1++;
            if(person2[i % person2.length] == answers[i]) cntP2++;
            if(person3[i % person3.length] == answers[i]) cntP3++;
        }

        int maxVal = Math.max(Math.max(cntP1, cntP2), cntP3);
        List<Integer> retList = new ArrayList<>();
        if(maxVal == cntP1) retList.add(1);
        if(maxVal == cntP2) retList.add(2);
        if(maxVal == cntP3) retList.add(3);

        return retList.stream().mapToInt(n->n).toArray();
    }
}
