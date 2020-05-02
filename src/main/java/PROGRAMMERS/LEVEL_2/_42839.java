package PROGRAMMERS.LEVEL_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 소수 찾기
 */

public class _42839 {
    public static void main(String[] args) {
        Solution_42839 s = new Solution_42839();
        String numbers = "17";
        System.out.println(s.solution(numbers));
    }
}

class Solution_42839{
    public int solution(String numbers) {
        int max = getMaxValue(numbers);
        boolean[] primeArr = getPrimeArr(max);
        return getAvailableCnt(numbers, primeArr);
    }

    private int getMaxValue(String numbers){
        char[] temp = numbers.toCharArray();
        Character[] charArr = new Character[temp.length];
        for(int i = 0 ; i < temp.length ; i++) charArr[i] = temp[i];

        Arrays.sort(charArr, Collections.reverseOrder());

        StringBuilder ts = new StringBuilder();
        for(Character cur : charArr) ts.append((char) cur);

        return Integer.parseInt(ts.toString());
    }

    private boolean[] getPrimeArr(int max){
        boolean[] primeArr = new boolean[max+1];
        Arrays.fill(primeArr, true);

        primeArr[1] = false;
        for(int i = 2 ; i <= (int) Math.sqrt(max) ; i++){
            if(primeArr[i]){
                for(int j = i + i ; j <= max ; j = j + i) primeArr[j] = false;
            }
        }

        return primeArr;
    }

    private int getAvailableCnt(String numbers, boolean[] primeArr){
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i = 0 ; i < numbers.length() ; i++){
            int cur = numbers.charAt(i) - '0';
            numMap.merge(cur, 1, Integer::sum);
        }

        int cnt = 0;
        for(int i = 2 ; i <= primeArr.length - 1 ; i++){
            if(primeArr[i]){
                int[] numCnt = new int[10];
                int temp = i;

                while(temp > 0){
                    numCnt[temp % 10]++;
                    temp /= 10;
                }

                boolean isValid = true;
                for(int t = 0 ; t < numCnt.length ; t++){
                    if(numCnt[t] > 0 && (numMap.get(t) == null || numCnt[t] > numMap.get(t))){
                        isValid = false;
                    }
                }

                if(isValid) cnt++;
            }
        }

        return cnt;
    }
}
