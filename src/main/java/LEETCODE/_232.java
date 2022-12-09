package LEETCODE;

import java.util.Stack;

public class _232 {
	private static class MyQueue {
		private Stack<Integer> st1;
		private Stack<Integer> st2;

		public MyQueue() {
			st1 = new Stack();
			st2 = new Stack();
		}

		public void push(int x) {
			st1.push(x);
		}

		public int pop() {
			if (st2.empty()) {
				while (!st1.empty()) {
					st2.push(st1.pop());
				}
			}

			return st2.pop();
		}

		public int peek() {
			if (st2.empty()) {
				while (!st1.empty()) {
					st2.push(st1.pop());
				}
			}

			return st2.peek();
		}

		public boolean empty() {
			return st1.empty() && st2.empty();
		}
	}
}
