package PROGRAMMERS.LEVEL_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 줄 서는 방법
 */

public class _12936 {
    public static void main(String[] args) {
        Solution_12936 s = new Solution_12936();
        int n = 3;
        long k = 5;
        for(int cur : s.solution(n, k)) System.out.println(cur);
    }
}

class Solution_12936{
    public int[] solution(int n, long k) {
        List<Integer> ret = new ArrayList<>();
        List<Integer> pickList = new LinkedList<>();

        // Pre Process
        long factorial = 1;
        for(int i = 1 ; i <= n ; i++){
            pickList.add(i);
            factorial *= i;
        }

        k--;
        while(n > 0){
            factorial /= n--;
            long idx = k / factorial;
            ret.add(pickList.get((int)idx));
            pickList.remove((int)idx);
            k %= factorial;
        }

        return ret.stream().mapToInt(c->c).toArray();
    }
}
