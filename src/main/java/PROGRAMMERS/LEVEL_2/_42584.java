package PROGRAMMERS.LEVEL_2;

/**
 * 주식가격
 */

public class _42584 {
    public static void main(String[] args) {
        Solution_42584 s = new Solution_42584();
        int[] prices = {1, 2, 3, 2, 3};
        for(int cur : s.solution(prices)){
            System.out.println(cur);
        }
    }
}

class Solution_42584{
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0 ; i < prices.length ; i++){
            int cnt = 0;
            for(int j = i + 1 ; j < prices.length ; j++){
                cnt++;
                if(prices[i] > prices[j]) break;
            }

            answer[i] = cnt;
        }

        return answer;
    }
}
