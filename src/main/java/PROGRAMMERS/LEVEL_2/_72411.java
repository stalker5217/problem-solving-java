package PROGRAMMERS.LEVEL_2;

import java.util.*;

public class _72411 {
    public static void main(String[] args) {
        Solution_72411 s = new Solution_72411();
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        for(String menu : s.solution(orders, course)){
            System.out.println(menu);
        }
    }
}

class Solution_72411{
    private Map<String, Integer> orderMap;

    public String[] solution(String[] orders, int[] course) {
        orderMap = new HashMap<>();
        List<String> answer = new ArrayList<>();

        for(String order : orders){
            boolean[] include = new boolean[order.length()];

            char[] charArr = order.toCharArray();
            Arrays.sort(charArr);
            order = new String(charArr);

            powerSet(0, order, include);
        }

        for(int kindCnt : course){
            pickNewMenu(kindCnt, answer);
        }

        Collections.sort(answer);

        return answer.toArray(String[]::new);
    }

    private void powerSet(int level, String order, boolean[] include){
        if(level == order.length()){
            int trueCnt = 0;
            for(boolean result : include){
                if(result) trueCnt++;
            }

            if(trueCnt > 1){
                StringBuilder sb = new StringBuilder();
                for(int i = 0 ; i < include.length ; i++){
                    if(include[i]) sb.append(order.charAt(i));
                }

                if(orderMap.containsKey(sb.toString())){
                    orderMap.put(sb.toString(), orderMap.get(sb.toString()) + 1);
                }
                else{
                    orderMap.put(sb.toString(), 1);
                }
            }

            return;
        }

        include[level] = false;
        powerSet(level+1, order, include);
        include[level] = true;
        powerSet(level+1, order, include);
    }

    private void pickNewMenu(int kindCnt, List<String> answer){
        int maxCnt = -1;
        for(String menu : orderMap.keySet()){
            if(menu.length() == kindCnt && orderMap.get(menu) > 1){
                maxCnt = (maxCnt > orderMap.get(menu)) ? maxCnt : orderMap.get(menu);
            }
        }

        if(maxCnt > 1){
            for(String menu : orderMap.keySet()){
                if(menu.length() == kindCnt && orderMap.get(menu) == maxCnt){
                    answer.add(menu);
                }
            }
        }
    }
}
