package PROGRAMMERS.LEVEL_4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 게임 맵 최단거리
 */

public class _1844 {
    public static void main(String[] args) {
        Solution_1844 s = new Solution_1844();
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(s.solution(maps));
    }
}

class Solution_1844 {
    private final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int solution(int[][] maps) {
        return bfs(maps);
    }

    private int bfs(int[][] maps){
        class Pair{
            public final int first;
            public final int second;

            public Pair(int first, int second){
                this.first = first;
                this.second = second;
            }
        }

        boolean[][] visit = new boolean[maps.length][maps[0].length];
        for(int i = 0 ; i < maps.length ; i++){
            Arrays.fill(visit[i], false);
        }

        Queue<Pair> candidate = new LinkedList<>();
        candidate.add(new Pair(0, 0));
        visit[0][0] = true;
        int cnt = 0;
        while(!candidate.isEmpty()){
            int curSize = candidate.size();

            cnt++;
            for(int i = 0 ; i < curSize ; i++){
                Pair cur = candidate.poll();

                if(cur.first == maps.length - 1 && cur.second == maps[i].length - 1){
                    return cnt;
                }

                for(int d = 0 ; d < dir.length ; d++){

                    if(cur.first + dir[d][0] >= 0
                    && cur.first + dir[d][0] < maps.length
                    && cur.second + dir[d][1] >= 0
                    && cur.second + dir[d][1] < maps[0].length
                    && maps[cur.first + dir[d][0]][cur.second + dir[d][1]] == 1
                    && !visit[cur.first + dir[d][0]][cur.second + dir[d][1]]
                    )
                    {
                        visit[cur.first + dir[d][0]][cur.second + dir[d][1]] = true;
                        candidate.add(new Pair(cur.first + dir[d][0], cur.second + dir[d][1]));
                    }

                }
            }
        }

        return -1;
    }
}
