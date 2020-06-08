package PROGRAMMERS.LEVEL_3;

import java.util.Arrays;

/**
 * 최고의 집합
 */

public class _12938 {
    public static void main(String[] args) {
        Solution_12938 s = new Solution_12938();
        int n = 2, ss = 9;
        for(int cur : s.solution(n, ss)) System.out.println(cur);
    }
}

class Solution_12938{
    public int[] solution(int n, int s) {
        // 불가능한 경우
        if(s / n == 0){
            return new int[]{-1};
        }

        int[] ret = new int[n];
        int quotient = s / n;
        int remainder = s % n;
        Arrays.fill(ret, quotient);
        for(int i = ret.length - 1 ; i > ret.length - 1 - remainder ; i--) ret[i]++;

        return ret;
    }
}
