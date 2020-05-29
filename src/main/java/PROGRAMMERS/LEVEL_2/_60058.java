package PROGRAMMERS.LEVEL_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 괄호 변환
 */

public class _60058 {
    public static void main(String[] args) {
        Solution_60058 s = new Solution_60058();
        String p = "()))((()";
        System.out.println(s.solution(p));
    }
}


class Solution_60058 {
    public String solution(String p) {
        return isCorrect(p) ? p : haveCorrect(p);
    }

    // 균형 잡힌 괄호 문자열 검사
    private boolean isBalanced(String p){
        List<Character> cList = new ArrayList<>();
        for(int i = 0 ; i < p .length() ; i++) cList.add(p.charAt(i));
        long left = cList.stream().filter(c -> c == '(').count();
        long right = cList.stream().filter(c -> c == ')').count();

        return left == right;
    }

    // 올바른 괄호 문자열 검사
    private boolean isCorrect(String p){
        Stack<Character> cStack = new Stack<>();

        boolean ret = true;
        for(int i = 0 ; i < p.length() ; i++){
            if(p.charAt(i) == '('){
                cStack.push('(');
            }
            else{
                if(!cStack.empty()){
                    cStack.pop();
                }
                else{
                    ret = false;
                    break;
                }
            }
        }

        // 마지막에 비어있어야함.
        if(!cStack.empty()) ret = false;

        return ret;
    }

    /**
     *  1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
     *  2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
     *  3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
     *    3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
     *  4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
     *    4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
     *    4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
     *    4-3. ')'를 다시 붙입니다.
     *    4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
     *    4-5. 생성된 문자열을 반환합니다.
     */
    private String haveCorrect(String w){
        // Step 1
        if(w.equals("")) return w;

        // Step 2
        String u = "", v = "";
        for(int i = 2 ; i <= w.length() ; i++){
            u = w.substring(0, i);
            v = w.substring(i);

            if(isBalanced(u)) break;
        }

        // Step 3
        if(isCorrect(u)){
            return u + haveCorrect(v);
        }
        // Step 4
        else{
            // 4-1
            StringBuilder z = new StringBuilder();
            z.append("(");
            // 4-2
            z.append(haveCorrect(v));
            // 4-3
            z.append(")");

            for(int i = 1; i < u.length() - 1 ; i++){
                if(u.charAt(i) == '(') z.append(")");
                else z.append("(");
            }

            return z.toString();
        }
    }
}
