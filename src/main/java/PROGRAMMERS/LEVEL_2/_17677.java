package PROGRAMMERS.LEVEL_2;

import java.util.*;

/**
 * [1차] 뉴스 클러스터링
 */

public class _17677 {
    public static void main(String[] args) {
        Solution_17677 s = new Solution_17677();
        String str1 = "FRANCE";
        String str2 = "french";
        System.out.println(s.solution(str1, str2));
    }
}

class Solution_17677 {
    public int solution(String str1, String str2) {
        Map<String, Integer> set1 = new HashMap<>();
        Map<String, Integer> set2 = new HashMap<>();

        for(int i = 0 ; i < str1.length() - 1 ; i++){
            String cur = str1.substring(i, i+2).toLowerCase();
            if(cur.matches("^[a-z][a-z]$")){
                if(set1.containsKey(cur)){
                    set1.put(cur, set1.get(cur) + 1);
                }
                else{
                    set1.put(cur, 1);
                }
            }
        }

        for(int i = 0 ; i < str2.length() - 1 ; i++){
            String cur = str2.substring(i, i+2).toLowerCase();
            if(cur.matches("^[a-z][a-z]$")){
                if(set2.containsKey(cur)){
                    set2.put(cur, set2.get(cur) + 1);
                }
                else{
                    set2.put(cur, 1);
                }
            }
        }

        Map<String, Integer> temp = new HashMap<>(set1);
        for(String key : set2.keySet()){
            if(temp.containsKey(key)){
                temp.put(key, Math.max(temp.get(key), set2.get(key)));
            }
            else{
                temp.put(key, set2.get(key));
            }
        }

        int sum = 0;
        for(String key : temp.keySet()){
            sum += temp.get(key);
        }

        temp = new HashMap<>();
        for(String key : set2.keySet()){
            if(set1.containsKey(key)){
                temp.put(key, Math.min(set1.get(key), set2.get(key)));
            }
        }

        int retain = 0;
        for(String key : temp.keySet()){
            retain += temp.get(key);
        }

        return sum > 0 ? 65536 * retain / sum : 65536;
    }
}
