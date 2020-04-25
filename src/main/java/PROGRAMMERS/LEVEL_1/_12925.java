package PROGRAMMERS.LEVEL_1;

/**
 * 문자열을 정수로 바꾸기
 */

public class _12925 {
    public static void main(String[] args) {
        Solution_12925 s = new Solution_12925();
        String ss = "-1234";
        System.out.println(s.solution(ss));
    }
}

class Solution_12925 {
    public int solution(String s) {
        return Integer.parseInt(s);
    }
}