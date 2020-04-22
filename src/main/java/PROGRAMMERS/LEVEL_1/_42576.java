package PROGRAMMERS.LEVEL_1;

import java.util.HashMap;
import java.util.Map;

/**
 * 완주하지 못한 선수
 */

public class _42576 {
    public static void main(String[] args){
        Solution_42576 s = new Solution_42576();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(s.solution(participant, completion));
    }
}

class Solution_42576{
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> nameList = new HashMap<>();
        for(String name : participant){
            nameList.merge(name, 1, Integer::sum);
        }

        for(String name : completion){
            nameList.put(name, nameList.get(name) - 1);
        }

        for(String name : nameList.keySet()){
            if(nameList.get(name) > 0){
                answer = name;
            }
        }

        return answer;
    }
}