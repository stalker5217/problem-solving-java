package PROGRAMMERS.LEVEL_1;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * K번째수
 */

public class _42748 {
    public static void main(String[] args) {
        Solution_42748 s = new Solution_42748();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        for(int result : s.solution(array, commands)){
            System.out.println(result);
        }
    }
}

class Solution_42748{
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int curIdx = 0;
        for(int[] command : commands){
            List<Integer> tempList = new ArrayList<>();

            for(int i = command[0] - 1 ; i <= command[1] - 1 ; i++){
                tempList.add(array[i]);
            }
            Collections.sort(tempList);

            answer[curIdx++] = tempList.get(command[2] - 1);
        }
        return answer;
    }
}
