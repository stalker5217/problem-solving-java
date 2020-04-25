package PROGRAMMERS.LEVEL_1;

/**
 * 피보나치 수
 */

public class _12945 {
    public static void main(String[] args){
        Solution_12945 s = new Solution_12945();
        int n = 10;
        System.out.println(s.solution(n));
    }
}

class Solution_12945{
    public int solution(int n) {
        int[] fibo = new int[n+1];

        fibo[0] = 0;
        fibo[1] = 1;
        fibo[2] = 1;

        for(int i = 3 ; i <= n ; i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
            fibo[i] %= 1234567;
        }

        return fibo[n];
    }
}
