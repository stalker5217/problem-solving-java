package PROGRAMMERS.LEVEL_3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 가장 먼 노드
 */

public class _49189 {
    public static void main(String[] args) {
        Solution_49189 s = new Solution_49189();
        int n = 6;
        int[][] edge = {
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2}
        };
        System.out.println(s.solution(n, edge));
    }
}

class Solution_49189 {
    public int solution(int n, int[][] edge) {
        boolean[][] isConnect = new boolean[n+1][n+1];
        boolean[] isVisit = new boolean[n+1];
        for(int[] connect : edge){
            isConnect[connect[0]][connect[1]] = true;
            isConnect[connect[1]][connect[0]] = true;
        }

        // 1번 연결 노드 삽입
        Queue<Integer> nodeQ = new LinkedList<>();
        int curSize = 0;
        isVisit[1] = true;
        for(int i = 1 ; i <= n ; i++) {
            if(isConnect[1][i]){
                isVisit[i] = true;
                nodeQ.add(i);
            }
        }
        while(!nodeQ.isEmpty()){
            curSize = nodeQ.size();
            for(int q = 0 ; q < curSize ; q++){
                int node = nodeQ.poll();
                for(int i = 1 ; i <= n ; i++) {
                    if(isConnect[node][i] && !isVisit[i]) {
                        isVisit[i] = true;
                        nodeQ.add(i);
                    }
                }
            }
        }

        return curSize;
    }
}