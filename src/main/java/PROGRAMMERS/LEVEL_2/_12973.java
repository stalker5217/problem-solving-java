package PROGRAMMERS.LEVEL_2;

import java.util.Stack;

/**
 * 짝지어 제거하기
 */

public class _12973 {
    public static void main(String[] args) {
        Solution_12973 s = new Solution_12973();
        String ss = "baabaa";
        System.out.println(s.solution(ss));
    }
}

class Solution_12973{
    public int solution(String s)
    {
        Stack<Character> cStack = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++){
            if(!cStack.empty() && cStack.peek() == s.charAt(i)) cStack.pop();
            else cStack.push(s.charAt(i));
        }

        return cStack.empty() ? 1 : 0;
    }
}