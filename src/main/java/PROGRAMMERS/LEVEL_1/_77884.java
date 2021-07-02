package PROGRAMMERS.LEVEL_1;

public class _77884 {
    public static void main(String[] args) {
        Solution_77884 s = new Solution_77884();
        System.out.println(s.solution(13, 17));
    }
}

class Solution_77884 {
    public int solution(int left, int right) {
        int answer = 0 ;

        for(int num = left ; num <= right ; num++) {
            int cnt = 0;
            for(int i = 1 ; i <= num ; i++) {
                if(num % i == 0) cnt++;
            }

            if(cnt % 2 == 0) answer += num;
            else answer -= num;
        }
        return answer;
    }
}