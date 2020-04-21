package PROGRAMMERS.LEVEL_1;

/**
 * 문자열 다루기 기본
 */

public class _12918 {
    public static void main(String[] args){
        Solution_12918 sol = new Solution_12918();

        String s = "a234";
        System.out.println(sol.solution(s));
    }
}

class Solution_12918{
    public boolean solution(String s) {
        boolean answer = true;

        if(!(s.length() == 4 || s.length() == 6)){
            answer = false;
        }

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                answer = false;
                break;
            }
        }

        return answer;
    }
}
