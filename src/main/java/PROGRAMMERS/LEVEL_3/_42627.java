package PROGRAMMERS.LEVEL_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 디스크 컨트롤러
 */

public class _42627 {
    public static void main(String[] args) {
        Solution_42627 s = new Solution_42627();
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(s.solution(jobs));
    }
}

class Solution_42627{
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt((int[] a) -> a[0]));

        Queue<Integer> waitJob = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        int sIdx = 0;
        int remain = 0;
        int time = 0;
        int totalTime = 0;

        while(sIdx < jobs.length || remain > 0 || !waitJob.isEmpty()){
            while(sIdx < jobs.length && jobs[sIdx][0] == time){
                waitJob.add(jobs[sIdx][1]);
                sIdx++;
            }

            if(remain == 0) {
                if(waitJob.isEmpty()){
                    time = jobs[sIdx][0];
                }
                else{
                    int nextJob = waitJob.poll();
                    remain = nextJob;
                    totalTime += nextJob;
                }
            }

            totalTime += waitJob.size();
            time++;
            remain--;
        }

        return totalTime / jobs.length;
    }
}
