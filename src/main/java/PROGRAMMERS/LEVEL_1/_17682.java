package PROGRAMMERS.LEVEL_1;

/**
 * [1차] 다트 게임
 */

public class _17682 {
    public static void main(String[] args){
        Solution_17682 s = new Solution_17682();
        System.out.println(s.solution("1D2S3T*"));
    }
}

class Solution_17682{
    public int solution(String dartResult){
        int answer;

        int[] score = new int[3];
        int idx = 0;
        for(int i = 0 ; i < 3 ; i++){
            // 점수 계산
            int temp = dartResult.charAt(idx);
            if(temp == '1'){
                if(dartResult.charAt(idx + 1) == '0') {
                    score[i] = 10;
                    idx++;
                }
                else score[i] = 1;
            }
            else{
                score[i] = temp - '0';
            }
            idx++;

            // 보너스 계산
            if(dartResult.charAt(idx) == 'D'){
                score[i] = (int)Math.pow(score[i], 2);
            }
            else if(dartResult.charAt(idx) == 'T'){
                score[i] = (int)Math.pow(score[i], 3);
            }
            idx++;

            // 옵션 계산
            if(idx < dartResult.length() && dartResult.charAt(idx) == '*'){
                score[i] *= 2;
                if(i > 0) score[i-1] *= 2;
                idx++;
            }
            else if(idx < dartResult.length() && dartResult.charAt(idx) == '#'){
                score[i] = -score[i];
                idx++;
            }
        }

        answer = score[0] + score[1] + score[2];

        return answer;
    }
}
