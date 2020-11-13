package PROGRAMMERS.LEVEL_2;

/**
 * 이진 변환 반복하기
 */

public class _70129 {
    public static void main(String[] args) {
        Solution_70129 s = new Solution_70129();
        String ss = "110010101001";
        for(int cur : s.solution(ss)){
            System.out.println(cur);
        }
    }
}

class Solution_70129{
    public int[] solution(String s) {
        int transCnt = 0;
        int removeZero = 0;
        while(!s.equals("1")){
            int oneCnt = countOne(s);
            removeZero += s.length() - oneCnt;
            s = toBinary(oneCnt);
            transCnt++;
        }

        int[] answer = new int[2];
        answer[0] = transCnt;
        answer[1] = removeZero;

        return answer;
    }

    public String toBinary(int n){
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n%2);
            n/=2;
        }

        return sb.reverse().toString();
    }

    public int countOne(String s){
        int length = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '1') ++length;
        }

        return length;
    }
}
