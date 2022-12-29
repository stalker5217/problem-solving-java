package LEETCODE;

import java.util.Objects;
import java.util.Stack;

public class _155 {
	private static class MinStack {
		private Stack<Integer> st;
		private Stack<Integer> minSt;

		public MinStack() {
			st = new Stack<>();
			minSt = new Stack<>();
		}

		public void push(int val) {
			st.add(val);

			if (minSt.isEmpty() || val <= minSt.peek()) {
				minSt.add(val);
			}
		}

		public void pop() {
			Integer target = st.pop();

			if (Objects.equals(minSt.peek(), target)) {
				minSt.pop();
			}
		}

		public int top() {
			return st.peek();
		}

		public int getMin() {
			return minSt.peek();
		}
	}
}
