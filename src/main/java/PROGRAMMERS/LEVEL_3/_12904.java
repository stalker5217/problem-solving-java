package PROGRAMMERS.LEVEL_3;

/**
 * 가장 긴 팰린드롬
 */

public class _12904{
    public static void main(String[] args){
        Solution_12904 s = new Solution_12904();
        String ss = "abcdcba";
        System.out.println(s.solution(ss));
    }
}

class Solution_12904
{
    public int solution(String s)
    {
        int answer = 0;

        for(int i = s.length() ; i > 0 ; i--){
            boolean result = checkPal(s, i);
            if(result){
                answer = i;
                break;
            }
        }

        return answer;
    }

    public boolean checkPal(String s, int size){
        boolean isExist = false;

        for(int i = 0 ; i <= s.length() - size ; i++){

            int startIdx = i;
            int endIdx = startIdx + size - 1;
            boolean isPal = true;

            // 팰린드롬 체크
            while(startIdx < endIdx){
                if(s.charAt(startIdx) != s.charAt(endIdx)){
                    isPal = false;
                    break;
                }

                startIdx++;
                endIdx--;
            }

            if(isPal){
                isExist = true;
                break;
            }
        }

        return isExist;
    }
}