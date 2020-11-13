package PROGRAMMERS.LEVEL_1;

import java.util.ArrayList;
import java.util.List;

/**
 * 3진법 뒤집기
 */

public class _68935 {
    public static void main(String[] args) {
        Solution_68935 s = new Solution_68935();
        int n = 45;
        System.out.println(s.solution(n));
    }
}

class Solution_68935{
    public int solution(int n) {
        List<Integer> num = new ArrayList<>();

        while(n > 0){
            num.add(n % 3);
            n /= 3;
        }

        int answer = 0;
        for(int i = num.size() - 1, mul = 1 ; i >= 0 ; i--, mul*=3){
            answer += num.get(i) * mul;
        }

        return answer;
    }
}
