package PROGRAMMERS.LEVEL_1;

import java.util.List;
import java.util.ArrayList;

/**
 * 같은 숫자는 싫어
 */

public class _12906 {
    public static void main(String[] args) {
        Solution_12906 s = new Solution_12906();
        int[] arr = {1,1,3,3,0,1,1};
        for(int i : s.solution(arr)){
            System.out.println(i);
        }
    }
}

class Solution_12906{
    public int[] solution(int[] arr) {
        List<Integer> mList = new ArrayList<>();

        int pre = -1;
        for (int value : arr) {
            if (pre != value) {
                mList.add(value);
            }
            pre = value;
        }

        return mList.stream().mapToInt(n->n).toArray();
    }
}
