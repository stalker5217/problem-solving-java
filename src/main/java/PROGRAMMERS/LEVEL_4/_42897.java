package PROGRAMMERS.LEVEL_4;

/**
 * 도둑질
 */

public class _42897 {
    public static void main(String[] args) {
        Solution_42897 s = new Solution_42897();
        int[] money = {1, 2, 3, 1};
        System.out.println(s.solution(money));
    }
}

class Solution_42897 {
    public int solution(int[] money) {
        // 첫번째 집을 터는 경우. 마지막 집은 털지 못함
        int[] dp1 = new int[money.length];
        // 첫번째 집을 털지 않는 경우.
        int[] dp2 = new int[money.length];

        dp1[0] = money[0];
        dp1[1] = money[0];

        dp2[0] = 0;
        dp2[1] = money[1];

        for(int i = 2 ; i < dp1.length - 1 ; i++){
            dp1[i] = Math.max(dp1[i-2] + money[i], dp1[i-1]);
        }

        for(int i = 2 ; i < dp2.length ; i++){
            dp2[i] = Math.max(dp2[i-2] + money[i], dp2[i-1]);
        }

        return Math.max(dp1[money.length - 2], dp2[money.length - 1]);
    }
}
