package PROGRAMMERS.LEVEL_1;

/**
 * [1차] 비밀지도
 */

public class _17681 {
    public static void main(String[] args) {
        Solution_17681 s = new Solution_17681();
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] answer = s.solution(n, arr1, arr2);
        for(String a : answer) System.out.println(a);
    }
}

class Solution_17681{
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        int[] mergeArr = new int[n];
        for(int i = 0 ; i < n ; i++){
            mergeArr[i] = arr1[i] | arr2[i];
        }

        for(int i = 0 ; i < n ; i++){
            int cur = mergeArr[i];
            int bit = (int)Math.pow(2, n-1);
            StringBuilder curString = new StringBuilder();

            for(int j = 0 ; j < n ; j++){
                int result = cur & bit;
                if(result == bit){
                    curString.append("#");
                }
                else{
                    curString.append(" ");
                }
                bit /= 2;
            }
            answer[i] = curString.toString();
        }

        return answer;
    }
}
