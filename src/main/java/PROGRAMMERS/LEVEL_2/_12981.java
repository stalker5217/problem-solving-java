package PROGRAMMERS.LEVEL_2;

import java.util.HashMap;
import java.util.Map;

/**
 * 영어 끝말잇기
 */

public class _12981 {
    public static void main(String[] args) {
        Solution_12981 s = new Solution_12981();
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] ans = s.solution(n, words);
        System.out.println(ans[0] + " " + ans[1]);
    }
}

class Solution_12981{
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Map<String, Boolean> alreadyExist = new HashMap<>();
        int curTurn = 0;
        int[] sayCnt = new int[n];
        for(int i = 0 ; i < words.length ; i++){
            sayCnt[curTurn]++;
            if(alreadyExist.get(words[i]) != null){
                answer[0] = curTurn+1;
                answer[1] = sayCnt[curTurn];
                break;
            }
            else if(i - 1 >= 0 && words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0)){
                answer[0] = curTurn+1;
                answer[1] = sayCnt[curTurn];
                break;
            }
            alreadyExist.put(words[i], true);
            curTurn++;
            curTurn %= n;
        }
        return answer;
    }
}