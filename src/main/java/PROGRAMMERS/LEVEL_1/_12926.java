package PROGRAMMERS.LEVEL_1;

/**
 * 시저 암호
 */

public class _12926 {
    public static void main(String[] args) {
        Solution_12926 s = new Solution_12926();
        String ss = "a A z";
        int n = 1;
        System.out.println(s.solution(ss, n));
    }
}

class Solution_12926{
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == ' ') answer.append(' ');
            // lower case
            else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                int newChar = s.charAt(i) + n;
                if(newChar > 'z') newChar -= 26;
                answer.append((char)newChar);
            }
            // upper case
            else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                int newChar = s.charAt(i) + n;
                if(newChar > 'Z') newChar -= 26;
                answer.append((char)newChar);
            }
        }

        return answer.toString();
    }
}