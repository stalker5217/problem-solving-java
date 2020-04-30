package PROGRAMMERS.LEVEL_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 가장 큰 수
 */

public class _42746 {
    public static void main(String[] args) {
        Solution_42746 s = new Solution_42746();
        int[] numbers = {121, 12};
        System.out.println(s.solution(numbers));
    }
}

class Solution_42746{
    public String solution(int[] numbers) {
        List<Integer> numList = new ArrayList<>();
        for(int cur : numbers) numList.add(cur);

        numList.sort(new myCompare());
        StringBuilder answer = new StringBuilder();
        for(int cur : numList){
            answer.append(cur);
        }

        if(answer.charAt(0) == '0') return "0";
        else return answer.toString();
    }
}

class myCompare implements Comparator<Integer>{
    @Override
    public int compare(Integer n1, Integer n2) {
        String s1 = String.valueOf(n1);
        String s2 = String.valueOf(n2);

        for(int i = 0 ; i < 4 ; i++){
            char charOfIdx1;
            char charOfIdx2;

            if(i >= s1.length()) charOfIdx1 = s1.charAt(i % s1.length());
            else charOfIdx1 = s1.charAt(i);

            if(i >= s2.length()) charOfIdx2 = s2.charAt(i % s2.length());
            else charOfIdx2 = s2.charAt(i);

            if(charOfIdx1 > charOfIdx2) return -1;
            else if(charOfIdx1 < charOfIdx2) return 1;
        }

        return 0;
    }
}
