package PROGRAMMERS.LEVEL_1;

/**
 * 가운데 글자 가져오기
 */

public class _12903 {
    public static void main(String[] args) {
        Solution_12903 s = new Solution_12903();
        String ss = "qwer";
        System.out.println(s.solution(ss));
    }
}

class Solution_12903{
    public String solution(String s) {
        String answer;
        if(s.length() % 2 == 0){
            answer = s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        }
        else{
            answer = s.substring(s.length() / 2, s.length() / 2 + 1);
        }

        return answer;
    }
}