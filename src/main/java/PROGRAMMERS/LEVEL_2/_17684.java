package PROGRAMMERS.LEVEL_2;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * [3차] 압축
 */

public class _17684 {
    public static void main(String[] args) {
        Solution_17684 s = new Solution_17684();
        String msg = "KAKAO";
        for(int cur : s.solution(msg)) System.out.println(cur);
    }
}

class Solution_17684{
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();

        // Init
        int dictIdx = 1;
        for(char i = 'A' ; i <= 'Z' ; i++){
            dict.put("" + i, dictIdx++);
        }

        List<Integer> ret = new ArrayList<>();
        for(int i = 0, len = 1 ; i + len <= msg.length() ;){
            if(dict.containsKey(msg.substring(i, i + len))){
                if(i + len == msg.length()){
                    ret.add(dict.get(msg.substring(i, i + len)));
                    break;
                }
                len++;
            }
            else{
                dict.put(msg.substring(i, i + len), dictIdx++);
                ret.add(dict.get(msg.substring(i, i + len - 1)));
                i += (len - 1);
                len = 1;
            }
        }

        return ret.stream().mapToInt(c -> c).toArray();
    }
}
