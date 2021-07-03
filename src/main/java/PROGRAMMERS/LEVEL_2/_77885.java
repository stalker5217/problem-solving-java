package PROGRAMMERS.LEVEL_2;

public class _77885 {
    public static void main(String[] args) {
        Solution_77885 s = new Solution_77885();
        long[] numbers = {2, 7};
        for(long number : s.solution(numbers)) {
            System.out.print(number + " ");
        }
    }
}

class Solution_77885 {
    public long[] solution(long[] numbers) {
        long[] answers = new long[numbers.length];

        for(int i = 0 ; i < numbers.length ; i++) {
            long answer = numbers[i];

            long firstZeroBit = 1;
            while((answer & firstZeroBit) > 0) firstZeroBit <<= 1;

            answer |= firstZeroBit;
            firstZeroBit >>= 1;
            if(firstZeroBit > 0) answer ^= firstZeroBit;

            answers[i] = answer;
        }

        return answers;
    }
}