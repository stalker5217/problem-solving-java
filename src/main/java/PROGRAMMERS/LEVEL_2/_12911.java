package PROGRAMMERS.LEVEL_2;

/**
 * 다음 큰 숫자
 */

public class _12911 {
    public static void main(String[] args) {
        Solution_12911 s = new Solution_12911();
        int n = 78;
        System.out.println(s.solution(n));
    }
}

class Solution_12911{
    public int solution(int n) {
        int inputCnt = counting(n);
        for(int i = n + 1 ; ; i++){
            if(inputCnt == counting(i)) return i;
        }
    }

    private int counting(int n){
        int cnt = 0;
        while(n > 0){
            int bit = n & 1;
            if(bit == 1) cnt++;
            n = n >> 1;
        }
        return cnt;
    }
}
