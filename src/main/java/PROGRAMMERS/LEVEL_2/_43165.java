package PROGRAMMERS.LEVEL_2;

import java.util.Stack;

/**
 * 타겟 넘버
 */

public class _43165 {
    public static void main(String[] args) {
        Solution_43165 s = new Solution_43165();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(s.solution(numbers, target));
    }
}

class Solution_43165{
    private final Stack<Integer> operStack = new Stack<>();
    private int globalTarget;
    private int[] globalNums;
    private int answer = 0;



    public int solution(int[] numbers, int target) {
        globalNums = new int[numbers.length];
        System.arraycopy(numbers, 0, globalNums, 0, numbers.length);

        globalTarget = target;

        dfs();

        return answer;
    }

    private void dfs(){
        if(operStack.size() == globalNums.length){
            final int PLUS = 1;
            int sum = 0;

            for(int i = 0 ; i < globalNums.length ; i++){
                if(operStack.get(i) == PLUS) sum += globalNums[i];
                else sum -= globalNums[i];
            }

            if(sum == globalTarget) answer++;

            return;
        }

        for(int i = 0 ; i <= 1 ; i++){
            operStack.add(i);
            dfs();
            operStack.pop();
        }
    }
}
