package PROGRAMMERS.LEVEL_1;

/**
 * 문자열 내 p와 y의 개수
 */

public class _12916 {
    public static void main(String[] args){
        Solution_12916 s = new Solution_12916();
        String ss = "pypy";
        System.out.println(s.solution(ss));
    }
}

class Solution_12916{
    public boolean solution(String s) {
        boolean answer;

        int pCnt = 0;
        int yCnt = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P') pCnt++;
            else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y') yCnt++;
        }

        answer = pCnt == yCnt;

        return answer;
    }
}
