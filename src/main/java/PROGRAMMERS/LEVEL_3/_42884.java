package PROGRAMMERS.LEVEL_3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 단속카메라
 */
public class _42884 {
    public static void main(String[] args) {
        int[][] routes = {
                {-20, 15},
                {-14, -5},
                {-18, -13},
                {-5, -3}
        };

        System.out.println(Solution_42884.solution(routes));
    }
}

class Solution_42884 {
    public static int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

        int cameraPosition = -30010;
        int cameraCnt = 0;
        for(int[] route : routes) {
            if(cameraPosition < route[0]) {
                cameraCnt++;
                cameraPosition = route[1];
            }
        }

        return cameraCnt;
    }
}
