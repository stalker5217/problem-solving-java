package PROGRAMMERS.LEVEL_1;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

/**
 * 문자열 내 마음대로 정렬하기
 */

public class _12915 {
    public static void main(String[] args) {
        Solution_12915 s = new Solution_12915();
        String[] strings = {"sun", "bed", "car", "aed"};
        int n = 1;
        for(String cur : s.solution(strings, n)){
            System.out.println(cur);
        }
    }
}

class Solution_12915{
    public String[] solution(String[] strings, int n) {
        List<myString> strList = new ArrayList<>();

        for(String cur : strings){
            myString ms = new myString(cur, cur.charAt(n));
            strList.add(ms);
        }

        strList.sort(new myCompare());

        String[] answer = new String[strList.size()];
        for(int i = 0 ; i < strList.size() ; i++){
            answer[i] = strList.get(i).str;
        }

        return answer;
    }
}

class myString{
    public String str;
    public char charOfIdx;

    public myString(String str, char charOfIdx){
        this.str = str;
        this.charOfIdx = charOfIdx;
    }
}

class myCompare implements Comparator<myString>{
    @Override
    public int compare(myString s1, myString s2) {
        if(s1.charOfIdx > s2.charOfIdx) return 1;
        else if(s1.charOfIdx < s2.charOfIdx) return -1;
        else{
          return s1.str.compareTo(s2.str);
        }
    }
}
