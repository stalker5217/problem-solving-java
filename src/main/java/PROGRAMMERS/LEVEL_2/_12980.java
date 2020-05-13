package PROGRAMMERS.LEVEL_2;

/**
 * 점프와 순간 이동
 */

public class _12980 {
    public static void main(String[] args) {
        Solution_12980 s = new Solution_12980();
        int n = 5000;
        System.out.println(s.solution(n));
    }
}

class Solution_12980{
    public int solution(int n) {
        int ans = 0;
        while(n > 0){
            if(n % 2 == 0){
                n /= 2;
            }
            else{
                n -= 1;
                ans++;
            }
        }
        return ans;
    }
}
