package PROGRAMMERS.LEVEL_2;

import java.util.Arrays;

/**
 * 구명보트
 */

public class _42885 {
    public static void main(String[] args) {
        Solution_42885 s = new Solution_42885();
        int[] people = {70, 80, 50};
        int limit = 100;
        System.out.println(s.solution(people, limit));
    }
}

class Solution_42885{
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int cnt = 0;
        for(int left = 0, right = people.length - 1 ; left <= right ; cnt++)
            if(limit >= people[right--] + people[left]) left++;

        return cnt;
    }
}
