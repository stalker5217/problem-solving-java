package PROGRAMMERS.LEVEL_1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class _86051 {
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
		Solution_86051 s = new Solution_86051();
		System.out.println(s.solution(numbers));
	}
}

class Solution_86051 {
	public int solution(int[] numbers) {
		return IntStream.range(0, 10).sum() - Arrays.stream(numbers).sum();
	}
}
