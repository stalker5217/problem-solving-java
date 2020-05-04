package PROGRAMMERS.LEVEL_2;

import java.util.List;
import java.util.ArrayList;

/**
 * 하노이의 탑
 */

public class _12946 {
    public static void main(String[] args) {
        Solution_12946 s = new Solution_12946();
        int n = 2;
        int[][] answer = s.solution(n);
        for (int[] ints : answer) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}

class Solution_12946{
    private final List<int[]> routeArr = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);

        int[][] answer = new int[routeArr.size()][2];
        for(int i = 0 ; i < routeArr.size() ; i++){
            System.arraycopy(routeArr.get(i), 0, answer[i], 0, routeArr.get(i).length);
        }

        return answer;
    }

    private void hanoi(int n, int start, int via, int target){
        if(n == 1){
            int[] cur = {start, target};
            routeArr.add(cur);
        }
        else{
            hanoi(n-1, start, target, via);
            int[] cur = {start, target};
            routeArr.add(cur);
            hanoi(n-1, via, start, target);
        }
    }
}