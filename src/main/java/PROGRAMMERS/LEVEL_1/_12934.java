package PROGRAMMERS.LEVEL_1;

/**
 * 정수 제곱근 판별
 */

public class _12934 {
    public static void main(String[] args){
        Solution_12934 s = new Solution_12934();
        long n = 10;

        System.out.println(s.solution(144));
    }
}

class Solution_12934{
    public long solution(long n) {
        long answer;

        long cur = 1;
        boolean isRight = false;
        while(cur * cur <= n){
            if(cur * cur == n) {
                isRight = true;
                break;
            }
            else cur++;
        }

        answer = isRight ? ((cur+1) * (cur+1)) : -1;

        return answer;
    }
}
