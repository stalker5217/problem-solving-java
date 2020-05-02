package PROGRAMMERS.LEVEL_2;

/**
 * 최댓값과 최솟값
 */

public class _12939 {
    public static void main(String[] args) {
        Solution_12939 s = new Solution_12939();
        String ss = "-1 -2 -3 -4";
        System.out.println(s.solution(ss));
    }
}

class Solution_12939{
    public String solution(String s) {
        int min = 987654321, max = -987654321;
        String[] strArr = s.split(" ");
        for(String str : strArr){
            int cur =  Integer.parseInt(str);
            min = Math.min(min, cur);
            max = Math.max(max, cur);
        }

        return min + " " + max;
    }
}