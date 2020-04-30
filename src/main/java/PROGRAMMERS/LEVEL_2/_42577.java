package PROGRAMMERS.LEVEL_2;

import java.util.Arrays;

/**
 * 전화번호 목록
 */

public class _42577 {
    public static void main(String[] args) {
        Solution_42577 s = new Solution_42577();
        String[] phone_book = {"1", "11", "2"};
        System.out.println(s.solution(phone_book));
    }
}

class Solution_42577{
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 0 ; i < phone_book.length ; i++){
            for(int j = i+1 ; j < phone_book.length ; j++){
                if(phone_book[j].startsWith(phone_book[i])) return false;
            }
        }
        return true;
    }
}