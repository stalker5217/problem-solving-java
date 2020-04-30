package PROGRAMMERS.LEVEL_2;

/**
 * 숫자의 표현
 */

public class _12924 {
    public static void main(String[] args) {
        Solution_12924 s = new Solution_12924();
        int n = 15;
        System.out.println(s.solution(n));
    }
}

class Solution_12924{
    public int solution(int n) {
        int answer = 0;

        for(int i = 1 ; i <= n ; i++){
            int sum = 0;
            for(int j = i ; j <= n ; j++){
                sum += j;
                if(sum > n) break;
                else if(sum == n) answer++;
            }
        }

        return answer;
    }
}
