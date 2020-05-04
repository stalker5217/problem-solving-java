package PROGRAMMERS.LEVEL_2;

import java.util.Stack;

public class _42585 {
    public static void main(String[] args) {
        Solution_42585 s = new Solution_42585();
        String arrangement = "()(((()())(())()))(())";
        System.out.println(s.solution(arrangement));
    }
}

class Solution_42585{
    public int solution(String arrangement) {
        Stack<Character> mStack = new Stack<>();
        int stickCnt = 0;
        for(int i = 0 ; i < arrangement.length() ; i++){
            if(arrangement.charAt(i) == '('){
                mStack.push(arrangement.charAt(i));
            }
            else{
                // Razer
                if(i - 1 >= 0 && arrangement.charAt(i-1) == '('){
                    mStack.pop();
                    stickCnt += mStack.size();
                }
                // Stick
                else{
                    mStack.pop();
                    stickCnt++;
                }
            }
        }

        return stickCnt;
    }
}
