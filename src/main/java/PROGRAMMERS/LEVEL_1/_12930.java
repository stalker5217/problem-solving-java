package PROGRAMMERS.LEVEL_1;

/**
 * 이상한 문자 만들기
 */

public class _12930 {
    public static void main(String[] args) {
        Solution_12930 s = new Solution_12930();
        String ss = "try hello world";
        System.out.println(s.solution(ss));
    }
}

class Solution_12930{
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        int charCnt = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == ' ') {
                answer.append(' ');
                charCnt = 0;
            }
            else if(charCnt % 2 ==  0) {
                answer.append(s.substring(i, i+1).toUpperCase());
                charCnt++;
            }
            else {
                answer.append(s.substring(i, i+1).toLowerCase());
                charCnt++;
            }
        }

        return answer.toString();
    }
}