package LEETCODE;

import java.util.Stack;

public class _394 {
	private static class Solution {
		public String decodeString(String s) {
			Stack<Integer> iterStack = new Stack<>();
			Stack<String> strStack = new Stack<>();
			strStack.push("");

			int num = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					num *= 10;
					num += s.charAt(i) - '0';
				} else if (s.charAt(i) == '[') {
					iterStack.push(num);
					num = 0;

					strStack.push("");
				} else if (s.charAt(i) == ']') {
					int iterCount = iterStack.pop();

					String pattern = strStack.pop();
					StringBuilder base = new StringBuilder(strStack.pop());

					while (iterCount-- > 0) {
						base.append(pattern);
					}

					strStack.push(base.toString());
				} else {
					String cur = strStack.pop();
					cur += s.charAt(i);
					strStack.push(cur);
				}
			}

			return strStack.pop();
		}
	}
}
