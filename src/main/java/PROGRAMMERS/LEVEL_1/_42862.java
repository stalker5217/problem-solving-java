package PROGRAMMERS.LEVEL_1;

import java.util.Arrays;

/**
 * 체육복
 */

public class _42862 {
    public static void main(String[] args) {
        Solution_42862 s = new Solution_42862();
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};
        System.out.println(s.solution(n, lost, reserve));
    }
}

class Solution_42862{
    public int solution(int n, int[] lost, int[] reserve) {
        // 학생의 체육복 개수
        int[] student = new int[n+1];
        Arrays.fill(student, 1);

        for(int lostIdx : lost){
            student[lostIdx]--;
        }

        for(int reserveIdx : reserve){
            student[reserveIdx]++;
        }

        for(int i = 1 ; i <= n ; i++){
            if(student[i] == 2){
                if(i-1 >= 1 && student[i-1] == 0){
                    student[i-1] = 1;
                    student[i] = 1;
                }

                else if(i+1 <= n && student[i+1] == 0){
                    student[i+1] = 1;
                    student[i] = 1;
                }
            }
        }

        int ret = 0;
        for(int i = 1 ; i <= n ; i++){
            if(student[i] >= 1) ret++;
        }

        return ret;
    }
}
