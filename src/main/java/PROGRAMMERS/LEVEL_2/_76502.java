package PROGRAMMERS.LEVEL_2;

import java.util.Stack;

public class _76502 {
    public static void main(String[] args) {
        Solution_76502 s = new Solution_76502();
        System.out.println(s.solution("[](){}"));
    }
}

class Solution_76502 {
    public int solution(String s) {
        int answer = 0;

        for(int i = 0 ; i < s.length() ; i++) {
            String target = s.substring(i) + s.substring(0, i);
            if(checkValid(target)) answer++;
        }

        return answer;
    }

    private boolean checkValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == '(') stack.push('(');
            else if(s.charAt(i) == '{') stack.push('{');
            else if(s.charAt(i) == '[') stack.push('[');
            else if(s.charAt(i) == ')' && !stack.empty() && stack.pop() == '(');
            else if(s.charAt(i) == '}' && !stack.empty() && stack.pop() == '{');
            else if(s.charAt(i) == ']' && !stack.empty() && stack.pop() == '[');
            else return false;
        }

        if(stack.empty()) return true;
        else return false;
    }
}
