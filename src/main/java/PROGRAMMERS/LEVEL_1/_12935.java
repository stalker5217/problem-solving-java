package PROGRAMMERS.LEVEL_1;

import java.util.ArrayList;
import java.util.List;

/**
 * 제일 작은 수 제거하기
 */

public class _12935 {
    public static void main(String[] args) {
        Solution_12935 s = new Solution_12935();
        int[] arr = {4,3,2,1};
        for(int i : s.solution(arr)){
            System.out.println(i);
        }
    }
}

class Solution_12935{
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            int[] answer;
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        int minVal = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            if(minVal > arr[i]) minVal = arr[i];
        }

        List<Integer> arrList = new ArrayList<>();
        for (int value : arr) {
            if (value != minVal) arrList.add(value);
        }

        return arrList.stream().mapToInt(n->n).toArray();
    }
}
