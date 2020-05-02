package BAEKJOON;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *  조합
 */

public class _2407 {
    public static void main(String[] args) {
        Solution_2407 s = new Solution_2407();
        s.solution();
    }
}

class Solution_2407{
    public void solution(){
        int n, k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        BigInteger answer = new BigInteger("1");
        for(int i = 1 ; i <= k ; i++){
            int a = n + 1 - i;
            answer = answer.multiply(new BigInteger(String.valueOf(a)));
            answer = answer.divide(new BigInteger(String.valueOf(i)));
        }

        System.out.println(answer);
    }
}
