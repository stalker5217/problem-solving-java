package PROGRAMMERS.LEVEL_2;

import java.util.*;

/**
 * 튜플
 */

public class _64065 {
    public static void main(String[] args) {
        Solution_64065 s = new Solution_64065();
        String input = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        for(int cur : s.solution(input)){
            System.out.println(cur);
        }
    }
}

class Solution_64065{
    public int[] solution(String s) {
        s = s.substring(0, s.length() - 2).replaceAll("\\{", "");
        String[] tupleString = s.split("},");
        List<Set<Integer>> tupleList = new ArrayList<>();

        for (String ts : tupleString) {
            Set<Integer> tuple = new HashSet<>();
            Arrays.stream(ts.split(",")).forEach(c -> tuple.add(Integer.parseInt(c)));
            tupleList.add(tuple);
        }

        tupleList.sort(Comparator.comparingInt(Set::size));

        List<Integer> retList = new ArrayList<>();
        for(int i = 0 ; i < tupleList.size() ; i++){
            if(i == 0) retList.addAll(tupleList.get(i));
            else{
                Set<Integer> cur = new HashSet<>(tupleList.get(i));
                cur.removeAll(tupleList.get(i-1));
                retList.addAll(cur);
            }
        }

        return retList.stream().mapToInt(c -> c).toArray();
    }
}
