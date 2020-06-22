package PROGRAMMERS.LEVEL_3;

import java.util.Arrays;

/**
 * 예산
 */

public class _43237 {
    public static void main(String[] args) {
        Solution_43237 s = new Solution_43237();
        int[] budgets = {120, 110, 140, 150};
        int M = 485;
        System.out.println(s.solution(budgets, M));
    }
}

class Solution_43237{
    public int solution(int[] budgets, int M) {
        int start = 0;
        int end = Arrays.stream(budgets).max().getAsInt();
        while(true){
            int upperLimit = (start + end) / 2;
            if(start > end) return upperLimit;

            int sum = Arrays.stream(budgets).map(c -> Math.min(c, upperLimit)).sum();
            if(sum > M) end = upperLimit - 1;
            else start = upperLimit + 1;
        }
    }
}
