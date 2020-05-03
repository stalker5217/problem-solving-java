package PROGRAMMERS.LEVEL_2;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 더 맵게
 */

public class _42626 {
    public static void main(String[] args) {
        Solution_42626 s = new Solution_42626();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(s.solution(scoville, K));
    }
}

class Solution_42626{
    public int solution(int[] scoville, int K) {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int cur : scoville) pq.add(cur);

        int mixCnt = 0;
        while(!pq.isEmpty() && pq.peek() < K){
            try{
                int one = pq.peek();
                pq.remove();
                int two = pq.peek();
                pq.remove();
                int newFood = one + two * 2;
                pq.add(newFood);
            }
            catch(Exception e){
                break;
            }

            //System.out.println(one + " " + two + " " + newFood);
            mixCnt++;
        }

        if(!pq.isEmpty() && pq.peek() >= K) return mixCnt;
        else return -1;
    }
}
