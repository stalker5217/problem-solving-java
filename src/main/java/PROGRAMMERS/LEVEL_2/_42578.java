package PROGRAMMERS.LEVEL_2;

import java.util.HashMap;
import java.util.Map;

/**
 * 위장
 */

public class _42578 {
    public static void main(String[] args) {
        Solution_42578 s = new Solution_42578();
        String[][] clothes = {
            {"yellow_hat", "headgear"},
            {"blue_sunglasses", "eyewear"},
            {"green_turban", "headgear"}
        };
        System.out.println(s.solution(clothes));
    }
}

class Solution_42578{
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();
        for(String[] cur : clothes){
            if(clothesMap.get(cur[1]) == null) clothesMap.put(cur[1], 2);
            else clothesMap.put(cur[1], clothesMap.get(cur[1]) + 1);
        }

        int answer = 1;
        for(String key : clothesMap.keySet()){
            answer *= clothesMap.get(key);
        }
        answer--; // 모두 다 안 입는 경우 하나 제외

        return answer;
    }
}
