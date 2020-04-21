package PROGRAMMERS.LEVEL_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  나누어 떨어지는 숫자 배열
 */

public class _12910 {
    public static void main(String[] args){
        Solution_12910 s = new Solution_12910();

        int[] arr = {5, 9, 7, 10};
        int divisor = 5;

        for(int i : s.solution(arr, divisor)){
            System.out.println(i);
        }
    }
}

class Solution_12910 {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answerList = new ArrayList<>();

        for(int i : arr){
            if(i % divisor == 0) answerList.add(i);
        }
        if(answerList.size() == 0) answerList.add(-1);

        Collections.sort(answerList);

        int[] ret = new int[answerList.size()];
        for(int i = 0 ; i < answerList.size() ; i++) ret[i] = answerList.get(i);

        return ret;
    }
}
