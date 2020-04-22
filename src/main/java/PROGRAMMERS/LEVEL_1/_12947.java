package PROGRAMMERS.LEVEL_1;

/**
 * 하샤드 수
 */

public class _12947 {
    public static void main(String[] args){
        Solution_12947 s = new Solution_12947();
        int x = 12;
        System.out.println(s.solution(x));
    }
}

class Solution_12947{
    public boolean solution(int x) {
        boolean answer = true;

        int origin_x = x;
        int sum = 0;
        while(x > 0){
            sum += x % 10;
            x /= 10;
        }

        if(origin_x % sum != 0) answer = false;
        return answer;
    }
}