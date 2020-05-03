package PROGRAMMERS.LEVEL_2;

import java.util.Stack;

/**
 * 올바른 괄호
 */

public class _12909 {
    public static void main(String[] args) {
        Solution_12909 s = new Solution_12909();
        String ss = "()()";
        System.out.println(s.solution(ss));
    }
}

class Solution_12909{
    boolean solution(String s) {
        Stack<Integer> mStack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '(') mStack.push(1);
            else{
                if(mStack.empty()) return false;
                else mStack.pop();
            }
        }

        return mStack.empty();
    }
}
