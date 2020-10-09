package PROGRAMMERS.LEVEL_3;

import java.util.*;

/**
 * 배달
 */

public class _12978 {
    public static void main(String[] args) {
        Solution_12978 s = new Solution_12978();
        int N = 6;
        int[][] road = {
                {1,2,1},
                {1,3,2},
                {2,3,2},
                {3,4,3},
                {3,5,2},
                {3,5,3},
                {5,6,1}
        };
        int K = 4;
        System.out.println(s.solution(N, road, K));
    }
}

class Solution_12978{
    private int vertexCnt;
    private List<List<Pair>> adj;

    public int solution(int N, int[][] road, int K) {
        vertexCnt = N;
        adj = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++) adj.add(new ArrayList<>());

        for(int[] r : road){
            int startV = r[0];
            int destV = r[1];
            int weight = r[2];

            adj.get(startV).add(new Pair(destV, weight));
            adj.get(destV).add(new Pair(startV, weight));
        }

        int[] dist = dijkstra();

        return (int) Arrays.stream(dist).filter(a -> a <= K).count();
    }


    private int[] dijkstra(){
        int[] dist = new int[vertexCnt + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        Queue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.first));
        pq.add(new Pair(0, 1));

        while(!pq.isEmpty()){
            int cost = pq.peek().first;
            int curPos = pq.peek().second;
            pq.poll();

            if(cost > dist[curPos]) continue;

            for(Pair p : adj.get(curPos)){
                int to = p.first;
                int viaCost = cost + p.second;

                if(viaCost < dist[to]){
                    dist[to] = viaCost;
                    pq.add(new Pair(dist[to], to));
                }
            }
        }

        return dist;
    }
}

class Pair {
    public int first;
    public int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}