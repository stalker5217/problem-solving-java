package PROGRAMMERS.LEVEL_1;

public class _87389 {
	public static void main(String[] args) {
		Solution_87389 s = new Solution_87389();
		int n = 10;
		System.out.println(s.solution(10));
	}
}

class Solution_87389 {
	public int solution(int n) {
		int answer = 0;
		for(int i = 2 ; ; i++) {
			if(n % i == 1) {
				answer = i;
				break;
			}
		}

		return answer;
	}
}
