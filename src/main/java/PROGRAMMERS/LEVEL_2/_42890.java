package PROGRAMMERS.LEVEL_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 후보키
 */

public class _42890 {
    public static void main(String[] args) {
        Solution_42890 s = new Solution_42890();
        String[][] relation = {
                {"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}
        };
        System.out.println(s.solution(relation));
    }
}

class Solution_42890{
    public int solution(String[][] relation) {
        int ret = 0;
        int rowSize = relation.length;
        int colSize = relation[0].length;

        // 컬럼 선택 조합 생성
        Integer[] colCombination = new Integer[(1 << colSize) - 1];
        for(int i = 0 ; i < (1 << colSize) - 1 ; i++) colCombination[i] = i + 1;

        boolean[] isValid = new boolean[(1 << colSize) - 1];
        Arrays.fill(isValid, true);

        for(int i = 0 ; i < colCombination.length ; i++){
            if(isValid[i]){
                int curSet = colCombination[i];
                Set<String> keySet = makeKeySet(relation, curSet);

                // 유일성 만족
                if(keySet.size() == rowSize){
                    for(int j = i + 1 ; j < colCombination.length ; j++){
                        // 최소성 만족 못하는 케이스 제거
                        if((curSet & colCombination[j]) == curSet) isValid[j] = false;
                    }
                    ret++;
                }
            }
        }

        return ret;
    }

    private Set<String> makeKeySet(String[][] relation, int curSet){
        Set<String> keySet = new HashSet<>();

        for(String[] curRow : relation){
            StringBuilder key = new StringBuilder();
            // key 생성
            for(int shift = curSet, idx = 0; shift > 0 ; shift = (shift >> 1), idx++){
                if((shift & 1) == 1){
                    key.append(curRow[idx]);
                    key.append("|");
                }
            }
            keySet.add(key.toString());
        }

        return keySet;
    }
}
