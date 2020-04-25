package PROGRAMMERS.LEVEL_1;

/**
 * 짝수와 홀수
 */

public class _12937 {
    public static void main(String[] args){
        Solution_12937 s = new Solution_12937();
        int num = 5;
        System.out.println(s.solution(num));
    }
}

class Solution_12937 {
    public String solution(int num) {
        return (num % 2 == 0) ? "Even" : "Odd";
    }
}
