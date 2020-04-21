package PROGRAMMERS.LEVEL_1;

/**
 * 약수의 합
 */

public class _12928 {
    public static void main(String[] args){
        Solution_12928 s = new Solution_12928();
        int n = 12;
        System.out.println(s.solution(n));
    }
}

class Solution_12928{
    public int solution(int n) {
        int answer = 0;

        for(int i = 1 ; i <= n ; i++){
            if(n % i == 0) answer += i;
        }

        return answer;
    }
}
