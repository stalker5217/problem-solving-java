package PROGRAMMERS.LEVEL_2;

import java.util.ArrayList;
import java.util.List;

/**
 * 숫자 야구
 */

public class _42841 {
    public static void main(String[] args) {
        Solution_42841 s = new Solution_42841();
        int[][] baseball = {
            {123, 1, 1},
            {356, 1, 0},
            {327, 2, 0},
            {489, 0, 1}
        };
        System.out.println(s.solution(baseball));
    }
}

class Solution_42841{
    private final List<List<Integer>> allCase = new ArrayList<>();
    private final List<Integer> curCase = new ArrayList<>();
    private final boolean[] isVisit = new boolean[10];

    public int solution(int[][] baseball) {
        int answer = 0;

        getAllCase();
        for(List<Integer> cur : allCase){
            boolean isPossible = true;
            for (int[] bb : baseball) {
                int temp = bb[0];
                List<Integer> query = new ArrayList<>();
                query.add(temp / 100);
                temp %= 100;
                query.add(temp / 10);
                temp %= 10;
                query.add(temp);

                int strike = 0;
                int ball = 0;

                for (int q = 0; q < query.size(); q++) {
                    if (query.get(q).equals(cur.get(q))) strike++;
                    else if (cur.contains(query.get(q))) ball++;
                }

                if (strike != bb[1] || ball != bb[2]) {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible) answer++;
        }

        return answer;
    }

    private void getAllCase(){
        int pickSize = 3;
        if(curCase.size() == pickSize){
            List<Integer> temp = new ArrayList<>(curCase);
            allCase.add(temp);
            return;
        }

        for(int i = 1 ; i <= 9 ; i++){
            if(!isVisit[i]){
                isVisit[i] = true;
                curCase.add(i);
                getAllCase();
                curCase.remove(curCase.size() - 1);
                isVisit[i] = false;
            }
        }
    }
}
