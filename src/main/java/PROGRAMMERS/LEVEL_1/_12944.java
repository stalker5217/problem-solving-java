package PROGRAMMERS.LEVEL_1;

/**
 * 평균 구하기
 */

public class _12944 {
    public static void main(String[] args){
        Solution_12944 s = new Solution_12944();
        int[] arr = {1, 2, 3, 4};
        System.out.println(s.solution(arr));
    }
}

class Solution_12944{
    public double solution(int[] arr) {
        double answer = 0;

        for (int value : arr) answer += value;
        answer /= arr.length;

        return answer;
    }
}
