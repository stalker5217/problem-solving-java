package PROGRAMMERS.LEVEL_1;

public class _86491 {
	public static void main(String[] args) {
		Solution_86491 s = new Solution_86491();
		int[][] sizes = {
			{60, 50},
			{30, 70},
			{60, 30},
			{80, 40}
		};
		System.out.println(s.solution(sizes));
	}
}

class Solution_86491 {
	public int solution(int[][] sizes) {
		int maxWidth = -1;
		int maxHeight = -1;
		for(int[] cur : sizes) {
			if(cur[0] < cur[1]) {
				int temp = cur[0];
				cur[0] = cur[1];
				cur[1] = temp;
			}
			maxWidth = Math.max(maxWidth, cur[0]);
			maxHeight = Math.max(maxHeight, cur[1]);
		}

		return maxWidth * maxHeight;
	}
}
