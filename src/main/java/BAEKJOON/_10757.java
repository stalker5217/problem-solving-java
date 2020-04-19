package BAEKJOON;

import java.math.BigInteger;
import java.util.Scanner;

public class _10757 {
    public static void main(String[] args){
        Solution_10757 a = new Solution_10757();
        a.solution();
    }
}

class Solution_10757{
    public void solution(){
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] inputArr = input.split(" ");

        BigInteger a = new BigInteger(inputArr[0]);
        BigInteger b = new BigInteger(inputArr[1]);

        System.out.println(a.add(b));
    }
}
