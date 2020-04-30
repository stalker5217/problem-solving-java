package PROGRAMMERS.LEVEL_2;

import java.util.Stack;

/**
 * 소수 만들기
 */

public class _12977 {
    public static void main(String[] args) {
        Solution_12977 s = new Solution_12977();
        int[] nums= {1,2,7,6,4};
        System.out.println(s.solution(nums));
    }
}

class Solution_12977{
    private Stack<Integer> choiceStack;
    private int n;
    private int[] numbers;
    private int cnt;

    public int solution(int[] nums) {
        int answer;

        numbers = new int[nums.length];
        System.arraycopy(nums, 0, numbers, 0, nums.length);
        choiceStack = new Stack<>();
        cnt = 0;
        n = nums.length;

        combination(0, 3);

        answer = cnt;

        return answer;
    }

    public void combination(int offset, int choiceRemain){
        if(choiceStack.size() == 3){
            int sum = 0;
            for (Integer integer : choiceStack) {
                sum += integer;
            }
            boolean result = isPrime(sum);
            if(result){
                cnt++;
            }

            return;
        }

        for(int i = offset ; i <= n - choiceRemain ; i++){
            choiceStack.add(numbers[i]);
            combination(i + 1, choiceRemain - 1);
            choiceStack.pop();
        }
    }

    public boolean isPrime(int val){
        int n = (int)Math.sqrt(val);

        boolean isPrime = true;
        for(int i = 2 ; i <= n ; i++){
            if(val % i == 0){
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}
