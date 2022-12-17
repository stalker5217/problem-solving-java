package LEETCODE;

import java.util.ArrayList;
import java.util.List;

public class _43 {
	private static class Solution {
		public String multiply(String num1, String num2) {
			List<String> interim = new ArrayList<>();
			for (int i2 = num2.length() - 1; i2 >= 0; i2--) {
				int a = num2.charAt(i2) - '0';
				int carry = 0;

				StringBuilder cur = new StringBuilder();
				for (int i1 = num1.length() - 1; i1 >= 0; i1--) {
					int b = num1.charAt(i1) - '0';

					int result = a * b + carry;
					carry = result / 10;
					result %= 10;

					cur.append(result);
				}

				if (carry > 0) {
					cur.append(carry);
				}

				cur.reverse();

				int pendingZeroCnt = num2.length() - i2 - 1;
				while (pendingZeroCnt-- > 0) {
					cur.append(0);
				}

				interim.add(cur.toString());
			}

			String answer = "0";
			for (String cur : interim) {
				answer = add(answer, cur);
			}

			for (int i = 0 ; i < answer.length() ; i++) {
				if (answer.charAt(i) != '0') {
					return answer.substring(i);
				}
			}

			return "0";
		}

		private String add(String num1, String num2) {
			StringBuilder result = new StringBuilder();

			int i1 = num1.length() - 1;
			int i2 = num2.length() - 1;
			int carry = 0;

			while (i1 >= 0 || i2 >= 0) {
				int cur = carry;

				if (i1 >= 0) {
					cur += num1.charAt(i1) - '0';
					i1--;
				}

				if (i2 >= 0) {
					cur += num2.charAt(i2) - '0';
					i2--;
				}

				carry = cur / 10;
				cur %= 10;

				result.append(cur);
			}

			if (carry > 0) {
				result.append(carry);
			}

			return result.reverse().toString();
		}
	}
}
