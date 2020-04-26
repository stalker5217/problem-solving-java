package PROGRAMMERS.LEVEL_1;

/**
 * 최대공약수와 최소공배수
 */

public class _12940 {
    public static void main(String[] args) {
        Solution_12940 s = new Solution_12940();
        int n = 3, m = 12;
        int[] answer = s.solution(n, m);
        System.out.println(answer[0] + " " + answer[1]);
    }
}

class Solution_12940{
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        answer[0] = gcd(n, m);
        answer[1] = n * m / gcd(n, m);

        return answer;
    }

    private int gcd(int a, int b){
        if(a < b){
            int temp = a;
            a = b;
            b = temp;
        }

        if(b == 0) return a;
        else return gcd(b, a%b);
    }
}
