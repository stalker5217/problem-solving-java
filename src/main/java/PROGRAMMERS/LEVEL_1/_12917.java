package PROGRAMMERS.LEVEL_1;

/**
 * 문자열 내림차순으로 배치하기
 */

public class _12917 {
    public static void main(String[] args) {
        Solution_12917 s = new Solution_12917();
        String ss = "Zbcdefg";
        System.out.println(s.solution(ss));
    }
}

class Solution_12917{
    public String solution(String ss) {
        char[] s = ss.toCharArray();
        for(int i = 1 ; i <= s.length ; i++){
            for(int j = i - 1 ; j > 0 ; j--){
                if(s[j] > s[j-1]){
                    char temp = s[j];
                    s[j] = s[j-1];
                    s[j-1] = temp;
                }
                else break;
            }
        }

        StringBuilder answer = new StringBuilder();
        for(char cur : s){
            answer.append(cur);
        }

        return answer.toString();
    }
}
