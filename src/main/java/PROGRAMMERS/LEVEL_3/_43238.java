package PROGRAMMERS.LEVEL_3;

import java.util.Arrays;

/**
 * 입국심사
 */

public class _43238 {
    public static void main(String[] args) {
        Solution_43238 s = new Solution_43238();
        int n = 6;
        int[] times = {7, 10};
        System.out.println(s.solution(n, times));
    }
}

class Solution_43238{
    public long solution(int n, int[] times) {
        long start = 1L;
        long end = Arrays.stream(times).max().getAsInt() * (long)n;
        long answer= end;

        while(start <= end){
            long time = (start + end) / 2;
            long doneCnt = Arrays.stream(times).mapToLong(c -> (time / c)).sum();

            if(doneCnt < n) start = time + 1;
            else{
                answer = Math.min(answer, time);
                end = time - 1;
            }
        }

        return answer;
    }
}
