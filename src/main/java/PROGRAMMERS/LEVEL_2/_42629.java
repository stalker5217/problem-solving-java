package PROGRAMMERS.LEVEL_2;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 라면공장
 */

public class _42629 {
    public static void main(String[] args) {
        Solution_42629 s = new Solution_42629();
        int stock = 4;
        int[] dates = {4, 10, 15};
        int[] supplies = {20, 5, 10};
        int k = 30;
        System.out.println(s.solution(stock, dates, supplies, k));
    }
}

class Solution_42629{
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);

        int factoryIdx = 0;
        int cnt = 0;
        for(int day = 0 ; day < k ; day++){
            if(factoryIdx < dates.length && dates[factoryIdx] <= day){
                pq.add(supplies[factoryIdx]);
                factoryIdx++;
            }

            if(stock <= 0){
                stock += pq.poll();
                cnt++;
            }

            stock--;
        }

        return cnt;
    }
}