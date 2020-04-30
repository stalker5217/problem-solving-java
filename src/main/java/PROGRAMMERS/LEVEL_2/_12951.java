package PROGRAMMERS.LEVEL_2;

/**
 * JadenCase 문자열 만들기
 */

public class _12951 {
    public static void main(String[] args) {
        Solution_12951 s = new Solution_12951();
        String ss ="a b c  ";
        System.out.println(s.solution(ss));
    }
}

class Solution_12951{
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        String[] splitResult = s.split(" ");
        for(String cur : splitResult){
            if(cur.length() > 0){
                answer.append(Character.toUpperCase(cur.charAt(0)));
                answer.append(cur.substring(1).toLowerCase());
            }
            answer.append(" ");
        }

        // 마지막 공백이 있는 경우 처리. (a b c   )
        for(int i = s.length() - 1 ; i >= 0 ; i--){
            if(s.charAt(i) == ' ') answer.append(" ");
            else break;
        }
        return answer.substring(0, answer.length() - 1);
    }
}
