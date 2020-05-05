package PROGRAMMERS.LEVEL_2;

/**
 * 멀쩡한 사각형
 */

public class _62048 {
    public static void main(String[] args) {
        Solution_62048 s = new Solution_62048();
        int w = 8, h = 12;
        System.out.println(s.solution(w, h));
    }
}

class Solution_62048{
    public long solution(int w,int h) {
        return (long)w * h - (w + h - gcd(Math.max(w, h), Math.min(w, h)));
    }

    private int gcd(int a, int b){
        return (b == 0) ? a : gcd(b, a % b);
    }
}