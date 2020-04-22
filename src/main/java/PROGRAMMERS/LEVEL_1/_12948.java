package PROGRAMMERS.LEVEL_1;

/**
 * 핸드폰 번호 가리기
 */

public class _12948 {
    public static void main(String[] args){
        Solution_12948 s = new Solution_12948();
        String phone_number = "01033334444";
        System.out.println(s.solution(phone_number));
    }
}

class Solution_12948{
    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();

        for(int i = 0 ; i < phone_number.length() ; i++){
            if(i < phone_number.length() - 4) answer.append('*');
            else answer.append(phone_number.charAt(i));
        }
        return answer.toString();
    }
}
