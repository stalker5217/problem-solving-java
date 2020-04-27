package PROGRAMMERS.LEVEL_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 실패율
 */

public class _42889 {
    public static void main(String[] args) {
        Solution_42889 s = new Solution_42889();
        int maxStage = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        for(int i : s.solution(maxStage, stages)){
            System.out.println(i);
        }
    }
}

class Solution_42889{
    public int[] solution(int maxStage, int[] stages) {
        int[] stageTry = new int[maxStage + 1];
        int[] stageClear = new int[maxStage + 1];
        for(int stage : stages){
            if(stage <= maxStage){
                stageTry[stage]++;
            }

            for(int i = 1 ; i <= stage ; i++){
                if(i > maxStage) break;
                stageClear[i]++;
            }
        }

        List<FailureRate> failList = new ArrayList<>();
        for(int i = 1 ; i <= maxStage ; i++){
            FailureRate cur = new FailureRate();
            if(stageClear[i] == 0) {
                cur.failureRate = 0;
            }
            else{
                cur.failureRate = (double)stageTry[i] / stageClear[i];
            }
            cur.index = i;
            failList.add(cur);
        }

        Comparator<FailureRate> compare = (f1, f2) -> Double.compare(f2.failureRate, f1.failureRate);
        failList.sort(compare);

        int[] answer = new int[maxStage];
        for(int i =  0 ; i < answer.length ; i++){
            answer[i] = failList.get(i).index;
        }

        return answer;
    }
}

class FailureRate{
    public double failureRate;
    public int index;
}
