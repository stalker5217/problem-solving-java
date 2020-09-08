package PROGRAMMERS.LEVEL_2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * [카카오 인턴] 수식 최대화
 */

public class _67257 {
    public static void main(String[] args) {
        Solution_67257 s = new Solution_67257();
        String expression = "100-200*300-500+20";
        System.out.println(s.solution(expression));
    }
}

class Solution_67257{
    public long solution(String expression) {
        long answer = Long.MIN_VALUE;

        List<String> inFix = tokenizingExpression(expression);
        List<Map<String, Integer>> opPriorities = getOpPriorities();
        for(Map<String, Integer> opPriority : opPriorities){
            List<String> postFix = makePostFix(inFix, opPriority);
            answer = Math.max(answer, Math.abs(getValue(postFix)));
        }


        return answer;
    }

    private List<String> tokenizingExpression(String expression){
        Set<Character> opSet = Stream.of('+', '-', '*').collect(Collectors.toSet());
        List<String> inFix = new ArrayList<>();

        int startIdx = 0;
        for(int endIdx = 0 ; endIdx < expression.length() ; endIdx++){
            if(opSet.contains(expression.charAt(endIdx))){
                inFix.add(expression.substring(startIdx, endIdx));
                inFix.add(expression.substring(endIdx, endIdx + 1));
                startIdx = endIdx + 1;
            }
        }

        inFix.add(expression.substring(startIdx));

        return inFix;
    }

    private List<Map<String, Integer>> getOpPriorities(){
        List<Map<String, Integer>> opPriorities = new ArrayList<>();

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("+", 1);
        map1.put("-", 2);
        map1.put("*", 3);
        opPriorities.add(map1);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("+", 1);
        map2.put("-", 3);
        map2.put("*", 2);
        opPriorities.add(map2);

        Map<String, Integer> map3 = new HashMap<>();
        map3.put("+", 2);
        map3.put("-", 1);
        map3.put("*", 3);
        opPriorities.add(map3);

        Map<String, Integer> map4 = new HashMap<>();
        map4.put("+", 2);
        map4.put("-", 3);
        map4.put("*", 1);
        opPriorities.add(map4);

        Map<String, Integer> map5 = new HashMap<>();
        map5.put("+", 3);
        map5.put("-", 1);
        map5.put("*", 2);
        opPriorities.add(map5);

        Map<String, Integer> map6 = new HashMap<>();
        map6.put("+", 3);
        map6.put("-", 2);
        map6.put("*", 1);
        opPriorities.add(map6);

        return opPriorities;
    }

    private List<String> makePostFix(List<String> inFix, Map<String, Integer> opPriority){
        Stack<String> opStack = new Stack<>();
        List<String> postFix = new ArrayList<>();

        for(String value : inFix){
            if(opPriority.containsKey(value)){
                while(!opStack.empty() && opPriority.get(opStack.peek()) >= opPriority.get(value))
                    postFix.add(opStack.pop());
                opStack.add(value);
            }
            else postFix.add(value);
        }

        while(!opStack.empty()) postFix.add(opStack.pop());

        return postFix;
    }

    private Long getValue(List<String> postFix){
        Set<String> opSet = Stream.of("+", "-", "*").collect(Collectors.toSet());

        Stack<Long> valueStack = new Stack<>();
        for(String value : postFix){
            if(opSet.contains(value)){
                long a = valueStack.pop();
                long b = valueStack.pop();

                switch (value) {
                    case "+":
                        valueStack.add(a + b);
                        break;
                    case "-":
                        valueStack.add(b - a);
                        break;
                    case "*":
                        valueStack.add(a * b);
                        break;
                }
            }
            else valueStack.add(Long.valueOf(value));
        }

        return valueStack.pop();
    }
}