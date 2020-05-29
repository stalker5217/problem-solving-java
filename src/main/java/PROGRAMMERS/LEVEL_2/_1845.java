package PROGRAMMERS.LEVEL_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 폰켓몬
 */

public class _1845 {
    public static void main(String[] args) {
        Solution_1845 s = new Solution_1845();
        int[] nums = {3,3,3,2,2,2};
        System.out.println(s.solution(nums));
    }
}

class Solution_1845{
    public int solution(int[] nums) {
        Set<Integer> pocSet = new HashSet<>();
        Arrays.stream(nums).forEach(pocSet::add);
        return Math.min(pocSet.size(), nums.length / 2);
    }
}
