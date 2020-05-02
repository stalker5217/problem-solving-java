package BAEKJOON;

/**
 * N개의 최소공배수
 */

public class _12953 {
    public static void main(String[] args) {
        Solution_12953 s = new Solution_12953();
        int[] arr = {2,6,8,14};
        System.out.println(s.solution(arr));
    }
}

class Solution_12953{
    public int solution(int[] arr) {
        boolean isFind = false;
        int cur = 1;
        while(!isFind){

            boolean isLCM = true;
            for(int i : arr){
                if(cur % i != 0){
                    isLCM = false;
                    break;
                }
            }

            if(isLCM) isFind = true;
            else cur++;
        }

        return cur;
    }
}