package LEETCODE;

public class _415 {
	private static class Solution {
		public String addStrings(String num1, String num2) {
			int index1 = num1.length() - 1;
			int index2 = num2.length() - 1;
			int carry = 0;
			StringBuilder answer = new StringBuilder();
			while (index1 >= 0 || index2 >= 0) {
				int a = index1 >= 0 ? num1.charAt(index1--) - '0' : 0;
				int b = index2 >= 0 ? num2.charAt(index2--) - '0' : 0;

				int result = a + b + carry;
				carry = result / 10;
				int remain = result % 10;

				answer.append(remain);
			}

			if (carry > 0) {
				answer.append(carry);
			}

			return answer.reverse().toString();
		}
	}
}
