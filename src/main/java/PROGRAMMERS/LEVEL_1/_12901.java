package PROGRAMMERS.LEVEL_1;

/**
 * 2016년
 */

public class _12901 {
    public static void main(String[] args){
        Solution_12901 s = new Solution_12901();
        int month = 5;
        int day = 24;
        System.out.println(s.solution(month, day));
    }
}

class Solution_12901{
    public String solution(int a, int b) {
        String answer = "";

        int[] months =  {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 4; // 1월 1일은 금요일

        for(int i = 0 ; i < a ; i++) totalDays += months[i];
        totalDays += b;

        switch(totalDays % 7) {
            case 0:
                answer = "SUN";
                break;
            case 1:
                answer = "MON";
                break;
            case 2:
                answer = "TUE";
                break;
            case 3:
                answer = "WED";
                break;
            case 4:
                answer = "THU";
                break;
            case 5:
                answer = "FRI";
                break;
            case 6:
                answer = "SAT";
                break;
        }

        return answer;
    }
}
