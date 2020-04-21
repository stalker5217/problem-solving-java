package PROGRAMMERS.LEVEL_1;

/**
 * 두 정수 사이의 합
 */

public class _12912 {
    public static void main(String[] args){
        Solution_12912 s = new Solution_12912();
        int a = 3;
        int b = 5;
        System.out.println(s.solution(a, b));
    }
}

class Solution_12912{
    public long solution(int a, int b){
        long sum = 0;

        int small = Math.min(a, b);
        int big = Math.max(a, b);

        for(int i = small ; i <= big ; i++){
            sum += i;
        }

        return sum;
    }
}
