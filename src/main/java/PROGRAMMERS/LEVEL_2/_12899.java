package PROGRAMMERS.LEVEL_2;

/**
 * 124 나라의 숫자
 */

public class _12899 {
    public static void main(String[] args) {
        Solution_12899 s = new Solution_12899();
        int n = 13;
        System.out.println(s.solution(n));
    }
}

class Solution_12899{
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        String[] num = {"4", "1", "2"};

        while(n > 0){
            answer.insert(0, num[n%3]);
            n = (n-1) / 3;
        }

        return answer.toString();
    }
}
