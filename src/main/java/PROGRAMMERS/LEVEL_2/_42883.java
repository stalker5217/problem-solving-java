package PROGRAMMERS.LEVEL_2;

/**
 * 큰 수 만들기
 */

public class _42883 {
    public static void main(String[] args) {
        Solution_42883 s = new Solution_42883();
        String number = "4177252841";
        int k = 4;
        System.out.println(s.solution(number, k));
    }
}

class Solution_42883{
    public String solution(String number, int k) {
        StringBuilder numList = new StringBuilder(number);

        boolean fullSearch = false;
        int startIdx = 0;
        for(int removeCnt = 0 ; removeCnt < k ; removeCnt++){
            if(!fullSearch){
                boolean isDeleted = false;
                for(int i = startIdx ; i < numList.length() - 1 ; i++){
                    // 현재 숫자보다 다음 숫자가 더 크면 현재 숫자를 삭제
                    if(numList.charAt(i) < numList.charAt(i+1)){
                        isDeleted = true;
                        numList.deleteCharAt(i);
                        startIdx  = (i == 0) ? 0 : i - 1;
                        break;
                    }
                }

                // 끝까지 돌았는데 안지워짐
                if(!isDeleted) {
                    fullSearch = true;
                    numList.deleteCharAt(numList.length() - 1);
                }
            }
            else{
                numList.deleteCharAt(numList.length() - 1);
            }
        }

        return numList.toString();
    }
}
