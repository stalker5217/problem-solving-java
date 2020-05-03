package PROGRAMMERS.LEVEL_2;

import java.util.Arrays;

/**
 * 최솟값 만들기
 */

public class _12941 {
    public static void main(String[] args) {
        Solution_12941 s = new Solution_12941();
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        System.out.println(s.solution(A, B));
    }
}

class Solution_12941{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0 ; i < A.length ; i++){
            answer += A[i] * B[B.length - 1 - i];
        }

        return answer;
    }
}
