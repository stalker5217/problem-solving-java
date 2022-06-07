package PROGRAMMERS.LEVEL_1;

public class _82612 {
	public static void main(String[] args) {
		Solution_82612 s = new Solution_82612();
		System.out.println(s.solution(3, 20, 4));
	}
}

class Solution_82612 {
	public long solution(int price, int money, int count) {
		long total = (long) count * (count + 1) * price / 2;
		return money > total ? 0L : total - money;
	}
}
