package PROGRAMMERS.LEVEL_1;

public class _76501 {
    public static void main(String[] args) {
        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};
        Solution_76501 s = new Solution_76501();
        System.out.println(s.solution(absolutes, signs));
    }
}

class Solution_76501{
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0 ; i < absolutes.length ; i++){
            if(signs[i]) answer += absolutes[i];
            else answer -= absolutes[i];
        }

        return answer;
    }
}
