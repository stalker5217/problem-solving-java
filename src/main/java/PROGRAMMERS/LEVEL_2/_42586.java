package PROGRAMMERS.LEVEL_2;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 기능개발
 */

public class _42586 {
    public static void main(String[] args) {
        Solution_42586 s = new Solution_42586();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        for(int cur : s.solution(progresses, speeds)){
            System.out.println(cur);
        }
    }
}

class Solution_42586{
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> dayQueue = new LinkedList<>();
        for(int i = 0 ; i < progresses.length ; i++){
            int distributeDay = ((100 - progresses[i]) % speeds[i] == 0) ? (100 - progresses[i]) / speeds[i] : ((100 - progresses[i]) / speeds[i]) + 1;
            dayQueue.add(distributeDay);
        }

        List<Integer> dayList = new ArrayList<>();
        while(!dayQueue.isEmpty()){
            int cur = dayQueue.poll();
            int cnt = 1;

            while(!dayQueue.isEmpty() && dayQueue.peek() <= cur){
                cnt++;
                dayQueue.remove();
            }

            dayList.add(cnt);
        }

        return dayList.stream().mapToInt(n->n).toArray();
    }
}
