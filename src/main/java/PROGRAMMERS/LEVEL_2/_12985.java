package PROGRAMMERS.LEVEL_2;

/**
 * 예상 대진표
 */

public class _12985 {
    public static void main(String[] args) {
        Solution_12985 s = new Solution_12985();
        int n = 8;
        int a = 4;
        int b = 7;
        System.out.println(s.solution(n,a,b));
    }
}

class Solution_12985{
    public int solution(int n, int a, int b)
    {
        int round = 1;
        while(true){
            if((a+1) / 2 == (b+1) / 2) return round;

            a = (a+1) / 2;
            b = (b+1) / 2;
            round++;
        }
    }
}
