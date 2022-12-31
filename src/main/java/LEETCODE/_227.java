package LEETCODE;

import java.util.Stack;

public class _227 {
	private static class Solution {
		public int calculate(String s) {
			Stack<Integer> st = new Stack<>();
			char operator = '+';
			int current = 0;
			for (int i = 0; i < s.length(); i++) {
				char character = s.charAt(i);
				if (Character.isDigit(character)) {
					current = current * 10 + character - '0';
				}

				if (!Character.isDigit(character) && !Character.isWhitespace(character) || i == s.length() - 1) {
					if (operator == '+') {
						st.push(current);
					} else if (operator == '-') {
						st.push(-current);
					} else if (operator == '*') {
						st.push(st.pop() * current);
					} else if (operator == '/') {
						st.push(st.pop() / current);
					}

					current = 0;
					operator = character;
				}
			}

			return st.stream().mapToInt(c -> c).sum();
		}
	}
}
