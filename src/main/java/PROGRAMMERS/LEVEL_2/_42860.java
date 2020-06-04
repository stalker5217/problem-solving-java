package PROGRAMMERS.LEVEL_2;

import java.util.ArrayList;
import java.util.List;

/**
 * 조이스틱
 */

public class _42860 {
    public static void main(String[] args) {
        Solution_42860 s = new Solution_42860();
        String name = "ABAAAAAAABA";
        System.out.println(s.solution(name));
    }
}

class Solution_42860{
    public int solution(String name) {
        List<Integer> needCnt = new ArrayList<>();
        for(int i = 0 ; i < name.length() ; i++){
            needCnt.add(getCnt(name.charAt(i)));
        }

        int remainCnt = needCnt.stream().mapToInt(c -> c).sum();
        int minSum = 0;
        int curIdx = 0;
        while(remainCnt > 0){
            int leftDist = 0;
            int leftIdx;
            int rightDist = 0;
            int rightIdx;

            // 좌측 최소 거리 탐색
            while(true){
                if(needCnt.get((curIdx - leftDist + needCnt.size()) % needCnt.size()) > 0){
                    leftIdx = (curIdx - leftDist + needCnt.size()) % needCnt.size();
                    break;
                }
                leftDist++;
            }

            // 우측 최소 거리 탐색
            while(true){
                if(needCnt.get((curIdx + rightDist) % needCnt.size()) > 0){
                    rightIdx = (curIdx + rightDist) % needCnt.size();
                    break;
                }
                rightDist++;
            }

            // 위치 결정 (false : 좌측 탐색, true : 우측 탐색)
            if(leftDist < rightDist){
                minSum += leftDist;
                curIdx = leftIdx;
            }
            else{
                minSum += rightDist;
                curIdx = rightIdx;
            }
            minSum += needCnt.get(curIdx);
            remainCnt -= needCnt.get(curIdx);
            needCnt.set(curIdx, 0);
        }

        return minSum;
    }

    private int getCnt(char target){
        return Math.min(target - 'A', 'Z' - target + 1);
    }
}
