package PROGRAMMERS.LEVEL_2;

/**
 * [3차] n진수 게임
 */

public class _17687 {
    public static void main(String[] args) {
        Solution_17687 s = new Solution_17687();
        int n = 2, t = 4, m = 2, p = 1;
        System.out.println(s.solution(n,t,m,p));
    }
}

class Solution_17687{
    public String solution(int n, int t, int m, int p) {
        StringBuilder simulation = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for(int i = 0 ; simulation.length() < (t-1) * m + p ; i++){
            simulation.append(convertNumber(i, n));
        }

        for(int i = 0 ; i < t ; i++){
            answer.append(simulation.charAt(i * m + p - 1));
        }

        return answer.toString();
    }

    private StringBuilder convertNumber(int value, int n){
        if(value == 0) return new StringBuilder("0");

        StringBuilder ret = new StringBuilder();
        while(value > 0){
            String cur;
            if((value % n) < 10) cur = String.valueOf(value % n);
            else{
                char alpha = (char) ('A' + (value % n) - 10);
                cur = String.valueOf(alpha);
            }
            ret.insert(0, cur);
            value /= n;
        }

        return ret;
    }
}
