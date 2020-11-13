package PROGRAMMERS.LEVEL_1;

/**
 * 내적
 */

public class _70128 {
    public static void main(String[] args) {
        Solution_70128 s = new Solution_70128();
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};
        System.out.println(s.solution(a, b));
    }
}

class Solution_70128{
    public int solution(int[] a, int[] b) {
        int dotProduct = 0;
        for(int i = 0 ; i < a.length ; i++){
            dotProduct += a[i] * b[i];
        }

        return dotProduct;
    }
}
