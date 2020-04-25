package PROGRAMMERS.LEVEL_1;

/**
 * 수박수박수박수박수박수?
 */

public class _12922 {
    public static void main(String[] args){
        Solution_12922 s = new Solution_12922();
        int n = 5;
        System.out.println(s.solution(n));
    }
}

class Solution_12922 {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        for(int i = 0 ; i < n ; i++){
            if(i % 2 == 0) answer.append("수");
            else answer.append("박");
        }

        return answer.toString();
    }
}
