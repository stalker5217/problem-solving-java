package PROGRAMMERS.LEVEL_2;

import java.util.ArrayList;
import java.util.List;

/**
 * 단체사진 찍기
 */

public class _1835 {
    public static void main(String[] args) {
        Solution_1835 s = new Solution_1835();
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        System.out.println(s.solution(n, data));
    }
}

class Solution_1835{
    private final char[] person = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private final boolean[] isVisit = new boolean[person.length];
    private final List<List<Character>> allCase = new ArrayList<>();
    private final List<Character> curCase = new ArrayList<>();

    public int solution(int n, String[] data) {
        int answer = 0;
        getAllCase();
        for(List<Character> curList : allCase){

            boolean isValidCase = true;
            for(String cmd : data){
                char a = cmd.charAt(0);
                char b = cmd.charAt(2);
                int cnt = cmd.charAt(4) - '0';
                char op = cmd.charAt(3);

                boolean isValid = false;
                switch (op){
                    case '>':
                        if(getBetweenCnt(curList, a, b) > cnt) isValid = true;
                        break;
                    case '<':
                        if(getBetweenCnt(curList, a, b) < cnt) isValid = true;
                        break;
                    case '=':
                        if(getBetweenCnt(curList, a, b) == cnt) isValid = true;
                        break;
                }

                if(!isValid){
                    isValidCase = false;
                    break;
                }
            }

            if(isValidCase) answer++;
        }

        return answer;
    }

    private void getAllCase(){
        if(curCase.size() == person.length){
            allCase.add(new ArrayList<>(curCase));
            return;
        }

        for(int i = 0 ; i < person.length ; i++){
            if(!isVisit[i]){
                isVisit[i] = true;
                curCase.add(person[i]);
                getAllCase();
                curCase.remove(curCase.size() - 1);
                isVisit[i] = false;
            }
        }
    }

    private int getBetweenCnt(List<Character> curList, char a, char b){
        return Math.abs(curList.indexOf(a) - curList.indexOf(b)) - 1;
    }
}
