package PROGRAMMERS.LEVEL_1;

/**
 * 콜라츠 추측
 */
public class _12943 {
    public static void main(String[] args){
        Solution_12943 s = new Solution_12943();
        int num = 626331;
        System.out.println(s.solution(num));
    }
}

class Solution_12943{
    public int solution(int n) {
        int answer = 0;

        long num = n;
        while(num > 1){
            if(num % 2 == 0) num = num / 2;
            else num = num * 3 + 1;
            answer++;
            if(answer > 500){
                answer = -1;
                break;
            }
        }

        return answer;
    }
}