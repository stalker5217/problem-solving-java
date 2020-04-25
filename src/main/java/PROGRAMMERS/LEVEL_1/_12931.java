package PROGRAMMERS.LEVEL_1;

/**
 * 자릿수 더하기
 */

public class _12931 {
    public static void main(String[] args){
        Solution_12931 s = new Solution_12931();
        int n = 123;
        System.out.println(s.solution(n));
    }
}

class Solution_12931{
    public int solution(int n) {
        int answer = 0;

        while(n > 0){
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }
}
