package PROGRAMMERS.LEVEL_2;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Collections;

/**
 * 야근 지수
 */

public class _12927 {
    public static void main(String[] args) {
        Solution_12927 s = new Solution_12927();
        int n = 4;
        int[] works = {4, 3, 3};
        System.out.println(s.solution(n, works));
    }
}

class Solution_12927{
    public long solution(int n, int[] works) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int cur : works) q.add(cur);
        for(int i = 0 ; i < n ; i++) q.add(q.poll() - 1);
        return q.stream().filter(c -> c >= 0).mapToLong(c -> c * c).sum();
    }
}
