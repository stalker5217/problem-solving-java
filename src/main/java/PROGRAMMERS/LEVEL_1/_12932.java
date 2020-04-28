package PROGRAMMERS.LEVEL_1;

import java.util.ArrayList;
import java.util.List;

/**
 * 자연수 뒤집어 배열로 만들기
 */

public class _12932 {
    public static void main(String[] args) {
        Solution_12932 s = new Solution_12932();
        long n = 12345;
        for(int i : s.solution(n)){
            System.out.println(i);
        }
    }
}

class Solution_12932{
    public int[] solution(long n) {
        List<Integer> mList = new ArrayList<>();

        while (n != 0) {
            mList.add((int) (n % 10));
            n /= 10;
        }

        return mList.stream().mapToInt(a->a).toArray();
    }
}
