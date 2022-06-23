package PROGRAMMERS.LEVEL_2;

public class _92335 {
	public static void main(String[] args) {
		System.out.println(Solution.solution(100, 10));
	}

	private static class Solution {
		public static int solution(int n, int k) {
			StringBuilder convert = new StringBuilder();
			while (n > 0) {
				convert.insert(0, n % k);
				n /= k;
			}

			int answer = 0;
			String[] split = convert.toString().split("0");
			for (String cur : split) {
				if ("".equals(cur)) {
					continue;
				}

				long value = Long.parseLong(cur);

				if (value == 1) {
					continue;
				}

				boolean isPrime = true;
				for (long i = 2; i * i <= value; i++) {
					if (value % i == 0) {
						isPrime = false;
						break;
					}
				}

				if (isPrime) {
					answer++;
				}
			}

			return answer;
		}
	}
}
