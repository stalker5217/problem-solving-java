package PROGRAMMERS.LEVEL_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  Level 1 : 정수 내림차순으로 배치하기
 */

public class _12933 {
    public static void main(String[] args){
        Solution_12933 s = new Solution_12933();
        long n = 118372;
        System.out.println(s.solution(n));
    }
}

class Solution_12933{
    public long solution(long n) {
        long answer = 0;

        List<Integer> nArr = new ArrayList<>();
        while(n > 0){
            nArr.add((int)(n % 10));
            n /= 10;
        }

        Collections.sort(nArr);

        long mul = 1;
        for(int i : nArr){
            answer += i * mul;
            mul *= 10;
        }

        return answer;
    }
}
