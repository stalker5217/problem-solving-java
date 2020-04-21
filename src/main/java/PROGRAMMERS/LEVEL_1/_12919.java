package PROGRAMMERS.LEVEL_1;

/**
 * 서울에서 김서방 찾기
 */
public class _12919 {
    public static void main(String[] args){
        Solution_12919 s = new Solution_12919();
        String[] seoul = {"Jane", "Kim"};
        System.out.println(s.solution(seoul));
    }
}

class Solution_12919{
    public String solution(String[] seoul) {
        String answer = "";
        for(int i = 0 ; i < seoul.length ; i++){
            if(seoul[i].compareTo("Kim") == 0){
                answer  = answer + i;
                break;
            }
        }

        answer = "김서방은 " + answer + "에 있다";

        return answer;
    }
}
