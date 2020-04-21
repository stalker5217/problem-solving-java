package PROGRAMMERS.LEVEL_1;

import java.util.Arrays;

/**
 * 소수 찾기
 */

public class _12921 {
    public static void main(String[] args){
        Solution_12921 s = new Solution_12921();
        int n = 10;

        System.out.println(s.solution(n));
    }
}

class Solution_12921 {
    public int solution(int n) {
        int answer = 0;

        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);

        for(int i = 2 ; i <= (int) Math.sqrt(n) ; i++){
            if(isPrime[i]){
                for(int a = i + i ; a <= n ; a += i){
                    isPrime[a] = false;
                }
            }
        }

        for(int i = 2 ; i <= n ; i++){
            if(isPrime[i]) answer++;
        }

        return answer;
    }
}
