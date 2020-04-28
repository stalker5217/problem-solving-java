package PROGRAMMERS.LEVEL_1;

/**
 * x만큼 간격이 있는 n개의 숫자
 */

public class _12954 {
    public static void main(String[] args) {
        Solution_12954 s = new Solution_12954();
        int x = 2, n = 5;
        for(long i : s.solution(x, n)){
            System.out.println(i);
        }
    }
}

class Solution_12954{
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for(int i = 0 ; i < n ; i++){
            answer[i] = (i+1) * x;
        }

        return answer;
    }
}
