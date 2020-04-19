package BAEKJOON;

import java.math.BigInteger;
import java.util.Scanner;

public class _1271 {
    public static void main(String[] args){
        Solution_1271 s = new Solution_1271();
        s.solution();
    }
}

class Solution_1271{
    public void solution(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] inputArr = input.split(" ");

        BigInteger a = new BigInteger(inputArr[0]);
        BigInteger b = new BigInteger(inputArr[1]);

        System.out.println(a.divide(b));
        System.out.println(a.mod(b));
    }

}
