package PROGRAMMERS.LEVEL_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 두 개 뽑아서 더하기
 */

public class _68644 {
    public static void main(String[] args){
        Solution_68644 s = new Solution_68644();
        int[] numbers = {2,1,3,4,1};
        for(int value : s.solution(numbers)){
            System.out.println(value);
        }
    }
}

class Solution_68644{
    public int[] solution(int[] numbers) {
        List<Integer> canMake = new ArrayList<>();
        Map<Integer, Boolean> existMap = new HashMap<>();

        for(int i = 0 ; i < numbers.length ; i++){
            for(int j = 0 ; j < numbers.length ; j++){
                if(i != j){
                    int cur = numbers[i] + numbers[j];
                    if(!existMap.containsKey(cur)){
                        existMap.put(cur, true);
                        canMake.add(cur);
                    }
                }
            }
        }

        return canMake.stream().sorted().mapToInt(c -> c).toArray();
    }
}
