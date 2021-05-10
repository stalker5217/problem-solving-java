package PROGRAMMERS.LEVEL_1;

public class _77484 {
    public static void main(String[] args) {
        Solution_77484 s = new Solution_77484();
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] answer = s.solution(lottos, win_nums);
        System.out.println(answer[0] + " " + answer[1]);
    }
}

class Solution_77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int sameCnt = 0;
        int zeroCnt = 0;
        for(int my : lottos){
            if(my == 0) {
                zeroCnt++;
                continue;
            }

            for(int win : win_nums){
                if(my == win){
                    sameCnt++;
                    break;
                }
            }
        }

        int best = Math.min(7 - (sameCnt + zeroCnt), 6);
        int worst = Math.min(7 - sameCnt, 6);

        return new int[]{
                best,
                worst
        };
    }
}
