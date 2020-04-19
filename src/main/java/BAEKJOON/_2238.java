package BAEKJOON;

import java.math.BigInteger;
import java.util.Scanner;

public class _2238 {
    public static void main(String[] args){
        Solution_2238 s = new Solution_2238();
        s.solution();
    }
}

class Solution_2238{
    public void solution(){
        Scanner sc = new Scanner(System.in);

        String first = sc.nextLine();
        String second = sc.nextLine();

        BigInteger a = new BigInteger(first);
        BigInteger b = new BigInteger(second);

        System.out.println(a.add(b));
        System.out.println(a.subtract(b));
        System.out.println(a.multiply(b));
    }
}
