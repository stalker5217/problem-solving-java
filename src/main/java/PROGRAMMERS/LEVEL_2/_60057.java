package PROGRAMMERS.LEVEL_2;

/**
 * 문자열 압축
 */

public class _60057 {
    public static void main(String[] args) {
        Solution_60057 s = new Solution_60057();
        String input = "abcabcabcabcdededededede";
        System.out.println(s.solution(input));
    }
}

class Solution_60057{
    public int solution(String s) {
        if(s.length() == 1) return 1;

        int answer = Integer.MAX_VALUE;
        // compLen : 압축 기준 길이
        for(int compLen = 1 ; compLen <= s.length() / 2 ; compLen++){
            StringBuilder result = new StringBuilder();
            for(int i = 0 ; i <= s.length() ; ){
                // 마지막 남는 부분 처리
                if(i + compLen > s.length()){
                    result.append(s.substring(i));
                    break;
                }

                String base = s.substring(i, i + compLen);
                int cnt = 1;
                while(true){
                    String target;
                    if(i + (compLen * cnt) + compLen <= s.length()){
                        target = s.substring(i + (compLen * cnt), i + (compLen * cnt) + compLen);
                    }
                    else break;

                    if(base.equals(target)) cnt++;
                    else break;
                }

                if(cnt > 1) result.append(cnt);
                result.append(base);
                i += compLen * (cnt);
            }

            answer = Math.min(answer, result.length());
        }

        return answer;
    }
}


