package PROGRAMMERS.LEVEL_3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 이중우선순위큐
 */

public class _42628 {
    public static void main(String[] args) {
        Solution_42628 s = new Solution_42628();
        String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
        for(int a : s.solution(operations)){
            System.out.println(a);
        }
    }
}

class Solution_42628{
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        Map<Integer, Integer> existCheck = new HashMap<>();

        for(String cur : operations){
            String[] commands = cur.split(" ");

            if(commands[0].compareTo("I") == 0){
                int num = Integer.parseInt(commands[1]);

                maxPQ.add(num);
                minPQ.add(num);

                existCheck.merge(num, 1, Integer::sum);
            }
            else if(commands[0].compareTo("D") == 0){
                int cmdParam = Integer.parseInt(commands[1]);

                if(cmdParam == -1){
                    while(true){
                        if(minPQ.isEmpty()) break;

                        int removeTarget = minPQ.poll();

                        if(existCheck.get(removeTarget) > 0){
                            existCheck.put(removeTarget, existCheck.get(removeTarget) - 1);
                            break;
                        }
                    }
                }
                else if(cmdParam == 1){
                    while(true){
                        if(maxPQ.isEmpty()) break;

                        int removeTarget = maxPQ.poll();

                        if(existCheck.get(removeTarget) > 0){
                            existCheck.put(removeTarget, existCheck.get(removeTarget) - 1);
                            break;
                        }
                    }
                }
            }
        }

        int maxResult = 0, minResult = 0;
        boolean isEmpty = true;
        while(!maxPQ.isEmpty()){
            int cur = maxPQ.peek();
            if(existCheck.get(cur) > 0){
                isEmpty = false;
                maxResult = cur;
                break;
            }
            else{
                maxPQ.remove();
            }
        }

        while(!minPQ.isEmpty()){
            int cur = minPQ.peek();
            if(existCheck.get(cur) > 0){
                isEmpty = false;
                minResult = cur;
                break;
            }
            else{
                minPQ.remove();
            }
        }

        int[] answer = new int[2];
        if(!isEmpty) {
            answer[0] = maxResult;
            answer[1] = minResult;
        }

        return answer;
    }
}
